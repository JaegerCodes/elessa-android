pluginManagement {
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

        maven {
            url = uri("https://cb4d-179-6-6-210.ngrok-free.app/artifactory/libs-release-local")
            credentials {
                username = "admin"
                password = "P7WxdLiZKSWD2yf"
            }
        }
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "llamasoft") {
                useModule("com.llamasoft.elessa.buildlogic:convention:${requested.version}")
            }
        }
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
