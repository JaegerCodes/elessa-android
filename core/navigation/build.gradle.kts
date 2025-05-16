plugins {
    id("llamasoft.android.library")
    id("llamasoft.android.compose")
    id("llamasoft.koin")
}

android {
    namespace = "com.llamasoft.elessa.navigation"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    api(libs.compose.navigation)
    implementation(libs.koin.androidx.compose)
}
