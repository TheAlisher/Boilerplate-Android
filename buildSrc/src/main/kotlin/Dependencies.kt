object Versions {

    const val AGP = "7.1.3"
    const val coroutines = "1.6.1"
    const val KSP = "1.6.21-1.0.5"
    const val core = "1.7.0"
    const val activity = "1.4.0"
    const val fragment = "1.4.1"
    const val lifecycle = "2.4.1"
    const val navigation = "2.4.2"
    const val hilt = "2.41"
    const val retrofit = "2.9.0"
    const val okHttp = "5.0.0-alpha.7"
    const val room = "2.4.2"
    const val paging = "3.1.1"
}

object Libraries {

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${
            Versions.coroutines
        }"
    }

    object UIComponents {
        const val material = "com.google.android.material:material:1.6.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val vbpd = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
    }

    object Activity {
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    }

    object Fragment {
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Paging {
        const val runtime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    }
}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object KSP {
        operator fun invoke() = "com.google.devtools.ksp"
    }

    object Navigation {
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {
        const val plugin = "com.google.dagger.hilt.android"
    }
}