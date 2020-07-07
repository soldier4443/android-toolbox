import com.turastory.androidtoolbox.build.android.configureAndroidCommons
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath("com.turastory:build-tools:0.0.1")
        classpath("com.turastory:build-tools-internal:0.0.1")
    }
}

val libVersionCode = 1
val libVersionName = "1.0.0"

allprojects {
    repositories {
        google()
        jcenter()
    }

    if (this != rootProject &&
        name != "lab" &&
        projectDir.parentFile.name != "incubating") {
        println("Library Configuration Targets: $name")
        configureAndroidCommons(libVersionCode, libVersionName)
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
