pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = "mercadoBitcoin"
include(":app")
include(":exchanges")
include(":exchanges:exchanges_domain")
include(":exchanges:exchanges_data")
include(":exchanges:exchanges_presentation")
include(":core")
