import com.turastory.androidtoolbox.build.Version
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm
import com.turastory.androidtoolbox.build.kotlinReflect
import com.turastory.androidtoolbox.build.lottie
import com.turastory.androidtoolbox.build.material
import com.turastory.androidtoolbox.build.rxAndroid
import com.turastory.androidtoolbox.build.rxBinding
import com.turastory.androidtoolbox.build.rxJava

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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        setEnabled(true)
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":databinding"))
    implementation(project(":lifecycle"))
    implementation(project(":animation"))

    implementation(material(Version.Lab.material))

    implementation(kotlinJvm)
    implementation(kotlinReflect)
    implementation(androidx("appcompat", version = Version.Lab.appcompat))
    implementation(androidx("core", "ktx", version = Version.Lab.core))
    implementation(androidx("constraintlayout", version = Version.Lab.constraintLayout))

    implementation(androidx("lifecycle", "extensions", version = Version.Libs.lifecycle))
    implementation(androidx("lifecycle", "runtime", version = Version.Lab.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = Version.Lab.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = Version.Lab.lifecycle))

    implementation(rxJava)
    implementation(rxAndroid)
    implementation(rxBinding())

    implementation("at.wirecube:additive_animations:1.6.2")
    implementation(lottie(Version.Lab.lottie))

    testImplementation(junit)
    androidTestImplementation("androidx.test:runner:${Version.Lab.test}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Version.Lab.espresso}")
}
