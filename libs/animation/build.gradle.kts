import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm
import com.turastory.androidtoolbox.build.lottie
import com.turastory.androidtoolbox.build.transitionx

dependencies {
    implementation(project(":core"))

    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Version.Libs.appcompat))
    implementation(androidx("core", "ktx", version = Version.Libs.core))

    implementation(androidx("transition", version = Version.transition))

    implementation(transitionx)
    implementation("at.wirecube:additive_animations:1.7.2")
    implementation(lottie(Version.Libs.lottie))

    testImplementation(archCore("testing", version = Version.Libs.archCore))
    testImplementation(junit)
}
