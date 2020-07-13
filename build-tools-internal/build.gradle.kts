import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.3.72"
}

group = "com.turastory"
version = "0.0.1"

repositories {
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly(kotlin("gradle-plugin"))
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly("com.android.tools.build:gradle:4.0.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

