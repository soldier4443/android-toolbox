import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.3.31"
}

group = "com.turastory"
version = "0.0.1"

repositories {
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("gradle-plugin"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.android.tools.build:gradle:3.4.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
