pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "AppTest"
val modules = arrayOf(
    ":app",
    ":core:ui",
    ":core:domain",
    ":core:network",
    ":core:common",
)
include(*modules)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
