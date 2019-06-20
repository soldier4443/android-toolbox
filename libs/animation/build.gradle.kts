import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm
import com.turastory.androidtoolbox.build.lottie
import com.turastory.androidtoolbox.build.transitionx

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Version.Android.compileSdkVersion)
    buildToolsVersion(Version.Android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Version.Android.minSdkVersion)
        targetSdkVersion(Version.Android.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Version.Libs.appcompat))
    implementation(androidx("core", "ktx", version = Version.Libs.core))

    implementation(androidx("transition", version = Version.transition))

    implementation(transitionx)
    implementation("at.wirecube:additive_animations:1.6.2")
    implementation(lottie(Version.Libs.lottie))

    testImplementation(archCore("testing", version = Version.Libs.archCore))
    testImplementation(junit)
}
