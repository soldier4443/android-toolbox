import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.internal.Libs
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Libs.appcompat))
    implementation(androidx("core", "ktx", version = Libs.core))
    implementation(androidx("lifecycle", "extensions", version = Libs.lifecycle))
    implementation(androidx("lifecycle", "runtime-ktx", version = Libs.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = Libs.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = Libs.lifecycle))
    testImplementation(archCore("testing", version = Libs.archCore))
    testImplementation(junit)
}
