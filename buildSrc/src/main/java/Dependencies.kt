import org.gradle.api.JavaVersion

object Config {
    const val application_id = "com.example.pokemon"
    const val compile_sdk = 32
    const val min_sdk = 27
    const val target_sdk = 32
    val java_version = JavaVersion.VERSION_1_8
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val details = ":detailsScreen"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"
}

object Versions {
    //Design
    const val appcompat = "1.4.1"
    const val material = "1.5.0"

    //Kotlin
    const val core = "1.7.0"
    const val stdlib = "1.6.20"

    //Retrofit
    const val retrofit = "2.6.0"
    const val converterGson = "2.6.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"

    //Koin
    const val koinAndroid = "3.1.2"
    const val koinViewModel = "3.1.2"
    const val koinAppCompat = "3.1.2"

    //Coil
    const val coil = "0.11.0"

    //Room
    const val roomKtx = "2.4.2"
    const val runtime = "2.4.2"
    const val roomCompiler = "2.4.2"

    // Coroutines
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.0"
    const val coroutinesAdapter = "0.9.2"
    const val adapterFactory = "1.0.0"
    const val viewmodelKtx = "2.4.1"
    const val livedataKtx = "2.4.1"

    //Test
    const val jUnit = "4.12"
    const val runner = "1.2.0"
    const val espressoCore = "3.2.0"


    // Glide
    const val glide = "4.11.0"
    const val services_maps = "17.0.1"
    const val compiler = "4.11.0"
    const val glideToVectorYou = "v2.0.0"

}


object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"

}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapter_coroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}

object Koin {
    const val koin_android = "io.insert-koin:koin-core:${Versions.koinAndroid}"
    const val koin_view_model = "io.insert-koin:koin-android:${Versions.koinViewModel}"
    const val koin_android_compat = "io.insert-koin:koin-android-compat:${Versions.koinAppCompat}"
}

object Coil {
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val adapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelKtx}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedataKtx}"
    const val factory = "tech.thdev:flow-call-adapter-factory:${Versions.adapterFactory}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val services = "com.google.android.gms:play-services-maps:${Versions.services_maps}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.compiler}"
    const val glideToVectorYou = "com.github.corouteam:GlideToVectorYou:${Versions.glideToVectorYou}"
}










