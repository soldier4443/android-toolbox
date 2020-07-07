import com.turastory.androidtoolbox.build.*

dependencies {
    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("core", "ktx", version = CommonVersions.core))
    testImplementation(archCore("testing", version = CommonVersions.archCore))
    testImplementation(junit(CommonVersions.junit))
}
