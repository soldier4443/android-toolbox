import com.turastory.androidtoolbox.build.*
import com.turastory.androidtoolbox.build.android.configureCommons

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    configureCommons(
        code = 1,
        name = "1.0.0"
    )

    buildTypes {
        getByName("release") {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    implementation(material(CommonVersions.material))

    implementation(kotlinJvm(CommonVersions.kotlin))
    implementation(kotlinReflect(CommonVersions.kotlin))
    implementation(androidx("appcompat", version = CommonVersions.appcompat))
    implementation(androidx("core", "ktx", version = CommonVersions.core))
    implementation(androidx("constraintlayout", version = CommonVersions.constraintLayout))

    implementation(androidx("lifecycle", "runtime-ktx", version = CommonVersions.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = CommonVersions.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = CommonVersions.lifecycle))

    implementation(rxJava(CommonVersions.rxJava))
    implementation(rxAndroid(CommonVersions.rxAndroid))
    implementation(rxKotlin(CommonVersions.rxKotlin))
    implementation(rxBinding(version = CommonVersions.rxBinding))

    implementation("at.wirecube:additive_animations:1.7.2")
    implementation(lottie(CommonVersions.lottie))
    implementation(calligraphy(CommonVersions.calligraphy))

    testImplementation(junit(CommonVersions.junit))
    androidTestImplementation("androidx.test:runner:${CommonVersions.test}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${CommonVersions.espresso}")
}
