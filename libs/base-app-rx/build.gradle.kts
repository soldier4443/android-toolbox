import com.turastory.androidtoolbox.build.*

android {
    buildFeatures {
        buildConfig = false
        resValues = false
    }
}

dependencies {
    api(project(":base-app"))
    implementation(project(":core"))
    implementation(project(":databinding"))
    implementation(androidx("databinding", "runtime", StudioConfig.version))

    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("activity", "ktx", version = CommonVersions.appcompat))
    implementation(androidx("fragment", "ktx", version = CommonVersions.appcompat))
    implementation(androidx("core", "ktx", version = CommonVersions.core))

    implementation(rxJava(CommonVersions.rxJava))

    testImplementation(archCore("testing", version = CommonVersions.archCore))
    testImplementation(junit(CommonVersions.junit))
}
