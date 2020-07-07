import com.turastory.androidtoolbox.build.*

dependencies {
    implementation(project(":core"))

    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("core", "ktx", version = CommonVersions.core))

    implementation(androidx("transition", version = CommonVersions.transition))


    implementation(transitionx(CommonVersions.transition))
    implementation("at.wirecube:additive_animations:1.7.2")
    implementation(lottie(CommonVersions.lottie))

    testImplementation(archCore("testing", version = CommonVersions.archCore))
    testImplementation(junit(CommonVersions.junit))
}
