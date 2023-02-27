plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.teamservice"
    compileSdk = 33
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
    kaptTest(libs.hilt.android.compiler)

    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)
    implementation(project(":core:network"))
}