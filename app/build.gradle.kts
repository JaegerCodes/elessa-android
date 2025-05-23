plugins {
    id("llamasoft.android.application")
    id("llamasoft.android.compose")
    id("llamasoft.android.jacoco")
    id("llamasoft.koin")
}

android {
    namespace = "com.llamasoft.elessa"

    defaultConfig {
        applicationId = "com.llamasoft.elessa"
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            pickFirsts += "META-INF/LICENSE.md"
            pickFirsts += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {
    implementation(project(":core:testing"))
    implementation(project(":core:network"))
    implementation(project(":core:navigation"))
    implementation(project(":elessa-ui"))
    // Home
    implementation(project(":home:data"))
    implementation(project(":home:domain"))
    implementation(project(":home:presentation"))

    // Notifications
    implementation(project(":notifications:presentation"))

    // Checkout
    implementation(project(":checkout:presentation"))

    implementation(libs.androidx.lifecycleRuntime.ktx)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
}
