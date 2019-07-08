import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.internal.Libs
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm
import com.turastory.androidtoolbox.build.lottie
import com.turastory.androidtoolbox.build.transitionx

dependencies {
    implementation(project(":core"))

    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Libs.appcompat))
    implementation(androidx("core", "ktx", version = Libs.core))

    implementation(androidx("transition", version = Libs.transition))


    implementation(transitionx(Libs.transition))
    implementation("at.wirecube:additive_animations:1.7.2")
    implementation(lottie(Libs.lottie))

    testImplementation(archCore("testing", version = Libs.archCore))
    testImplementation(junit)
}
