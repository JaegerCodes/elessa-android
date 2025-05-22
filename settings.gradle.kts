pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Elessa"
include(":app")
include(":elessa-ui")
include(":notifications")
include(":checkout")
include(":core:testing")
include(":core:network")
include(":core:model")
include(":home:presentation")
include(":home:data")
include(":home:domain")
include(":core:model")
include(":core:accessibility")
include(":core:navigation")
include(":notifications:presentation")
include(":checkout:presentation")
