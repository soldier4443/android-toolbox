import com.turastory.androidtoolbox.build.internal.StudioConfig
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.internal.Libs
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Libs.appcompat))
    implementation(androidx("recyclerview", version = Libs.recyclerview))
    implementation(androidx("core", "ktx", version = Libs.core))
    implementation(androidx("databinding", "adapters", StudioConfig.version))
    implementation(androidx("databinding", "common", StudioConfig.version))
    implementation(androidx("databinding", "runtime", StudioConfig.version))
    testImplementation(junit)
}
