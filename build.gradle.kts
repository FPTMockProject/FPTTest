plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
   // alias(libs.plugins.google.service) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.dependencyanalysis)
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}