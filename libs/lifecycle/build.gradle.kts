import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.archCore
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

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
    implementation(androidx("lifecycle", "extensions", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "runtime-ktx", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = Version.Libs.lifecycle))
    testImplementation(archCore("testing", version = Version.Libs.archCore))
    testImplementation(junit)
}
