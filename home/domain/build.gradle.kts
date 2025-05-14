plugins {
    id("llamasoft.android.library")
    id("llamasoft.library.jacoco")
    id("llamasoft.koin")
}

android {
    namespace = "com.llamasoft.elessa.domain"

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
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)

    implementation(project(":core:model"))
}
