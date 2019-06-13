import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Version.Android.compileSdkVersion)
    buildToolsVersion(Version.Android.buildToolsVersion)

    defaultConfig {
        applicationId = "com.turastory.androidtoolbox"
        minSdkVersion(Version.Android.minSdkVersion)
        targetSdkVersion(Version.Android.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlinJvm)
    implementation(androidx("appcompat", version = Version.Lab.appcompat))
    implementation(androidx("core", "ktx", version = Version.Lab.core))
    implementation(androidx("constraintlayout", version = Version.Lab.constraintLayout))
    testImplementation(junit)
    androidTestImplementation("androidx.test:runner:${Version.Lab.test}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Version.Lab.espresso}")
}
