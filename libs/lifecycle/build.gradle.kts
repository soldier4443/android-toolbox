import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Version.Libs.appcompat))
    implementation(androidx("core", "ktx", version = Version.Libs.core))
    implementation(androidx("lifecycle", "extensions", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "runtime-ktx", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = Version.Libs.lifecycle))
    testImplementation(archCore("testing", version = Version.Libs.archCore))
    testImplementation(junit)
}
