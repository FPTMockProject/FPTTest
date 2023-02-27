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
    ":feature:search",
    ":feature:participation-team",
    ":feature:matches",
    ":core:ui",
    ":core:domain",
    ":core:network",
    ":core:common",
    ":service:team-service"
)
include(*modules)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
