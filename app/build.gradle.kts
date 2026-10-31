plugins {
    id("com.android.application")
}

// CI passes the run number so every build installs as an update over the last one.
val buildNumber = (System.getenv("BUILD_NUMBER") ?: "1").toInt()

android {
    namespace = "com.sunwardgrove.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sunwardgrove.app"
        minSdk = 26
        targetSdk = 35
        versionCode = buildNumber
        versionName = "1.0.$buildNumber"
    }

    signingConfigs {
        create("release") {
            // A fixed key so new builds install over old ones. Fine for personal sideloading;
            // swap for a secret-backed key before publishing to a store.
            storeFile = rootProject.file("keystore/sunward-release.jks")
            storePassword = "sunwardgrove"
            keyAlias = "sunward"
            keyPassword = "sunwardgrove"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
