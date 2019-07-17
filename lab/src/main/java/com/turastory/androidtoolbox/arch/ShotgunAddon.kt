package com.turastory.androidtoolbox.arch

import com.turastory.androidtoolbox.arch.ShotgunAddon.Effect
import com.turastory.androidtoolbox.arch.ShotgunAddon.Intent
import com.turastory.androidtoolbox.arch.ShotgunAddon.State
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.withLatestFrom
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class ShotgunAddon(
    private val base: Base
) : Addon<Intent, Effect, State> {

    /**
     * Intent - an intent of user
     */
    sealed class Intent {
        object PullTrigger : Intent()
        object Reload : Intent()
    }

    sealed class Effect {
        object Reloading : Effect()
        object Reloaded : Effect()
        data class HitEffect(val shotResult: String) : Effect()
    }

    data class State(
        val reloading: Boolean = false,
        val shotResult: String = "",
        val logText: String = ""
    )

    private val shotgun = Shotgun()
    private var internalState = State()

    private val intentStream: PublishSubject<Intent> = PublishSubject.create()
    private val stateStream: BehaviorSubject<State> = BehaviorSubject.createDefault(internalState)

    private var scheduler: Scheduler = Schedulers.io()

    override val actor: Actor<Intent, Effect>
        get() = { intent ->
            when (intent) {
                Intent.PullTrigger -> {
                    shotgun.shot()
                        .map { listOf(Effect.HitEffect(it) as Effect) }
                        .startWith(listOf(Effect.Reloading))
                }
                Intent.Reload -> shotgun.reload().map {
                    listOf(
                        Effect.Reloaded
                    )
                }
            }
        }

    override val reducer: Reducer<Effect, State>
        get() = { effect, state ->
            when (effect) {
                Effect.Reloading -> {
                    state.copy(
                        reloading = true,
                        logText = state.logText.append("reloading!")
                    )
                }
                Effect.Reloaded -> {
                    state.copy(
                        reloading = false,
                        logText = state.logText.append("reloaded!")
                    )
                }
                is Effect.HitEffect -> {
                    state.copy(
                        shotResult = effect.shotResult,
                        logText = state.logText.append(effect.shotResult)
                    )
                }
            }
        }

    override val postProcessor: PostProcessor<State, Intent?>?
        get() = { intent, state ->
            if (intent == Intent.Reload && state.reloading) Intent.Reload
            else null
        }

    override fun accept(intent: Intent) {
        intentStream.onNext(intent)
    }

    override fun subscribe(observer: Observer<in State>) {
        val disposable = stateStream
            .observeOn(scheduler)
            .subscribe({ state ->
                observer.onNext(state)
            }, Throwable::printStackTrace)

        base.add(disposable)
    }

    fun forUi(): Addon<Intent, Effect, State> {
        scheduler = AndroidSchedulers.mainThread()
        return this
    }

    init {
        intentStream
            .flatMap { intent -> actor(intent) }
            .withLatestFrom(stateStream)
            .map { (effects, state) ->
                reduceState(effects to state)
            }
            .subscribe({ state ->
                stateStream.onNext(state)
            }, Throwable::printStackTrace)
            .disposedBy(base)

        stateStream
            .withLatestFrom(intentStream)
            .map { (state, intent) ->
                postProcessor?.invoke(intent, state)?.let { newIntent ->
                    intentStream.onNext(newIntent)
                }
            }
            .subscribe()
            .disposedBy(base)
    }

    private fun reduceState(pair: Pair<List<Effect>, State>): State {
        val (effects, state) = pair
        var intermediateState = state
        effects.forEach { effect ->
            intermediateState = reducer(effect, intermediateState)
        }
        return intermediateState
    }

    private fun String.append(logLine: String): String = this + "\n$logLine"
}