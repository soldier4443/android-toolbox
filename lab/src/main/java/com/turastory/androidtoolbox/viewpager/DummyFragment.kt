package com.turastory.androidtoolbox.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.turastory.androidtoolbox.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

class DummyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dummy, container, false)
    }

    val dataStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")

    private val disposables = CompositeDisposable()
    private val api = FakeApi()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.text)

        api.loadMessage()
            .subscribe({ msg ->
                text?.text = msg
                dataStream.onNext(msg)
            }, Throwable::printStackTrace)
            .apply { disposables.add(this) }
    }
}