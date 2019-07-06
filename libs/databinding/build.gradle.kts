import com.turastory.androidtoolbox.build.StudioConfig
import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Version.Libs.appcompat))
    implementation(androidx("recyclerview", version = Version.Libs.recyclerview))
    implementation(androidx("core", "ktx", version = Version.Libs.core))
    implementation(androidx("databinding", "adapters", StudioConfig.version))
    implementation(androidx("databinding", "common", StudioConfig.version))
    implementation(androidx("databinding", "runtime", StudioConfig.version))
    testImplementation(junit)
}
