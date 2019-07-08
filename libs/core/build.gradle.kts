import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.internal.Libs
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Libs.appcompat))
    implementation(androidx("core", "ktx", version = Libs.core))
    testImplementation(archCore("testing", version = Libs.archCore))
    testImplementation(junit)
}
