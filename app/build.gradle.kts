
configurations.all {
    resolutionStrategy.force("com.squareup:javapoet:1.13.0")
}
// ================= Plugins =================
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("org.jetbrains.kotlin.kapt") // Add this
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.navigation.safe.args)
    alias(libs.plugins.ksp)

}

apply(plugin = "org.jetbrains.kotlin.kapt")
hilt {
    enableAggregatingTask = false
}
// ================= Android Configuration =================
android {
    namespace = "com.example.moviesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviesapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        javaParameters = true
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

//// ================= KAPT Configuration =================
kapt {
    correctErrorTypes = true
    useBuildCache = true
    includeCompileClasspath = false
}

// ================= Dependencies =================
dependencies {

    /* ---------------- Core ---------------- */
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    /* ---------------- UI ---------------- */
    implementation(libs.fragment)
    implementation(libs.recyclerview)
    implementation(libs.cardview)
    implementation(libs.swiperefreshlayout)

    /* ---------------- Navigation ---------------- */
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    /* ---------------- Lifecycle ---------------- */
    implementation(libs.lifecycle.runtime.ktx)

    /* ---------------- Networking ---------------- */
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlin.serialization)

    /* ---------------- Room (KSP) ---------------- */
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    /* ---------------- Glide (KAPT) ---------------- */
    implementation(libs.glide)
    kapt(libs.glide.compiler)

    /* ---------------- Hilt (KAPT) ---------------- */
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation("com.squareup:javapoet:1.13.0")
    /* ---------------- Testing ---------------- */
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
