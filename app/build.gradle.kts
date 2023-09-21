plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //추가

    id("kotlin-parcelize")
    id("kotlin-android")
}

android {
    namespace = "com.companyname.imagesearchpage"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.companyname.imagesearchpage"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Converter ( JSON 타입 결과를 객체로 매핑 )
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // okhttp3
    implementation("com.squareup.okhttp3:logging-interceptor:4.5.0")
    // Gson
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    implementation ("com.github.bumptech.glide:glide:4.14.1")
    implementation ("androidx.fragment:fragment-ktx:1.6.1")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}