import com.turastory.androidtoolbox.build.android.configureCommons
import com.turastory.androidtoolbox.build.androidx
import com.turastory.androidtoolbox.build.calligraphy
import com.turastory.androidtoolbox.build.internal.Lab
import com.turastory.androidtoolbox.build.internal.Libs
import com.turastory.androidtoolbox.build.junit
import com.turastory.androidtoolbox.build.kotlinJvm
import com.turastory.androidtoolbox.build.kotlinReflect
import com.turastory.androidtoolbox.build.lottie
import com.turastory.androidtoolbox.build.material
import com.turastory.androidtoolbox.build.rxAndroid
import com.turastory.androidtoolbox.build.rxBinding
import com.turastory.androidtoolbox.build.rxJava
import com.turastory.androidtoolbox.build.rxKotlin

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

    implementation(material(Lab.material))

    implementation(kotlinJvm)
    implementation(kotlinReflect)
    implementation(androidx("appcompat", version = Lab.appcompat))
    implementation(androidx("core", "ktx", version = Lab.core))
    implementation(androidx("constraintlayout", version = Lab.constraintLayout))

    implementation(androidx("lifecycle", "extensions", version = Libs.lifecycle))
    implementation(androidx("lifecycle", "runtime", version = Lab.lifecycle))
    implementation(androidx("lifecycle", "viewmodel-ktx", version = Lab.lifecycle))
    implementation(androidx("lifecycle", "livedata-ktx", version = Lab.lifecycle))

    implementation(rxJava)
    implementation(rxAndroid)
    implementation(rxKotlin)
    implementation(rxBinding())

    implementation("at.wirecube:additive_animations:1.7.2")
    implementation(lottie(Lab.lottie))
    implementation(calligraphy(Lab.calligraphy))

    testImplementation(junit)
    androidTestImplementation("androidx.test:runner:${Lab.test}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Lab.espresso}")
}
