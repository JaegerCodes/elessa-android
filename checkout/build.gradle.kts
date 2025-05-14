plugins {
    id("llamasoft.android.library")
    id("llamasoft.android.compose")
    id("llamasoft.library.jacoco")
}

android {
    namespace = "com.llamasoft.elessa.checkout"

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
    implementation(libs.androidx.lifecycleRuntime.ktx)
    implementation(libs.compose.navigation)
    implementation(libs.material)
}