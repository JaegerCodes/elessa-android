plugins {
    id("llamasoft.android.library")
    id("llamasoft.library.jacoco")
    id("llamasoft.android.compose")
    id("llamasoft.koin")
}

android {
    namespace = "com.llamasoft.elessa.presentation"

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
    implementation(project(":core:model"))
    implementation(project(":elessa-ui"))
    implementation(project(":home:domain"))
    implementation(libs.koin.androidx.compose)
    implementation(libs.lottie)
}
