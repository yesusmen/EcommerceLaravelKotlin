import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)

    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.codeboss.ecommercelaravelkotlin"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.codeboss.ecommercelaravelkotlin"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //Icons Extended Material
    implementation(libs.androidx.compose.material.icons.extended)

    //Navigation
    implementation(libs.androidx.navigation.compose.android)
    implementation(libs.androidx.navigation.compose)

    // Dagger Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)

    // Gson
    implementation(libs.gson)

    // Retrofit + Gson
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //DATA STORE
    implementation(libs.androidx.datastore.preferences)

    //JWT
    implementation(libs.java.jwt)

    //MOSHI
    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.kotlin.codegen)

    //COIL
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)


    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)





}