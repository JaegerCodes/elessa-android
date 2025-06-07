plugins {
    id("llamasoft.android.library")
    id("llamasoft.library.jacoco")
}

android {
    namespace = "com.llamasoft.elessa.core.testing"

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

    // Testing
    api(libs.junit)

    // Android Testing
    api(libs.androidx.test.ext)
    api(libs.androidx.test.espresso)

    api(libs.mockk.android)
    api(libs.mockk.agent)

    api(libs.kotlinx.coroutines.test)
}
