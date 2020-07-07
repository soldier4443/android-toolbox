import com.turastory.androidtoolbox.build.*

dependencies {
    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("core", "ktx", version = CommonVersions.core))
    implementation(androidx("lifecycle", "extensions", version = CommonVersions.lifecycle))
    implementation(androidx("lifecycle", "runtime-ktx", version = CommonVersions.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = CommonVersions.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = CommonVersions.lifecycle))
    testImplementation(archCore("testing", version = CommonVersions.archCore))
    testImplementation(junit(CommonVersions.junit))
}
