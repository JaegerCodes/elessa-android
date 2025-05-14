plugins {
    id("llamasoft.android.library")
    id("llamasoft.library.jacoco")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.llamasoft.elessa.model"

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
    implementation(libs.androidx.annotation.jvm)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    ksp(libs.moshi.ksp)
}
