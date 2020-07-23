import com.turastory.androidtoolbox.build.*

dependencies {
    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("recyclerview", version = CommonVersions.recyclerview))
    implementation(androidx("core", "ktx", version = CommonVersions.core))
    implementation(androidx("databinding", "adapters", StudioConfig.version))
    implementation(androidx("databinding", "common", StudioConfig.version))
    implementation(androidx("databinding", "runtime", StudioConfig.version))
    testImplementation(junit(CommonVersions.junit))
}
