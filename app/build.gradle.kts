import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.util.Properties

plugins {
    id("llamasoft.android.application")
    id("llamasoft.android.compose")
    id("llamasoft.android.jacoco")
    id("llamasoft.koin")
}

val versionProps = Properties().apply {
    load(rootProject.file("delivery/version.properties").inputStream())
}

val major = versionProps["MAJOR"].toString().toInt()
val minor = versionProps["MINOR"].toString().toInt()
val patch = versionProps["PATCH"].toString().toInt()
val code = versionProps["CODE"].toString().toInt()

val versionName = "$major.$minor.$patch"
val versionCode = code

val appBaseName = "Elessa"

android {
    namespace = "com.llamasoft.elessa"

    defaultConfig {
        applicationId = "com.llamasoft.elessa"
        this.versionCode = versionCode
        this.versionName = versionName
    }

    flavorDimensions += "environment"

    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            resValue("string", "app_name", "\"$appBaseName dev $versionName\"")
            resValue("color", "launcher_color", "#7f8c8d")
        }
        create("stage") {
            dimension = "environment"
            applicationIdSuffix = ".stage"
            versionNameSuffix = "-stage"
            resValue("string", "app_name", "\"$appBaseName stage $versionName\"")
            resValue("color", "launcher_color", "#2980b9")
        }
        create("prod") {
            dimension = "environment"
            resValue("string", "app_name", "\"$appBaseName\"")
        }
    }

    buildTypes {
        getByName("debug") {
            enableUnitTestCoverage = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    applicationVariants.all {
        outputs.all {
            val output = this as BaseVariantOutputImpl
            val flavor = flavorName
            val buildType = buildType.name
            output.outputFileName = "elessa-$flavor-$buildType-v$versionName.apk"
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
