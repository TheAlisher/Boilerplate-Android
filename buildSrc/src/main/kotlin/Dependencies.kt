object Versions {

    const val AGP = "8.2.1"
    const val kotlin = "1.9.22"
    const val coroutines = "1.8.0-RC2"
    const val KSP = "1.9.22-1.0.16"
    const val material = "1.11.0"
    const val constraintLayout = "2.1.4"
    const val vbpd = "1.5.9"
    const val core = "1.12.0"
    const val splashscreen = "1.0.1"
    const val activity = "1.8.2"
    const val fragment = "1.6.2"
    const val lifecycle = "2.6.2"
    const val navigation = "2.7.6"
    const val dagger = "2.50"
    const val retrofit = "2.9.0"
    const val moshi = "1.15.0"
    const val okHttp = "4.12.0"
    const val room = "2.6.1"
    const val paging = "3.2.1"
}

object Libraries {

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${
            Versions.coroutines
        }"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${
            Versions.coroutines
        }"
    }

    object UIComponents {
        const val material = "com.google.android.material:material:${
            Versions.material
        }"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${
            Versions.constraintLayout
        }"
        const val vbpd = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${
            Versions.vbpd
        }"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val splashscreen = "androidx.core:core-splashscreen:${Versions.splashscreen}"
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

    /**
     * For Hilt in domain module
     *
     * [javax.inject package](https://docs.oracle.com/javaee%2F6%2Fapi%2F%2F/javax/inject/package-summary.html)
     * [JSR-330](https://javax-inject.github.io/javax-inject/)
     */
    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Paging {
        const val common = "androidx.paging:paging-common:${Versions.paging}"
        const val runtime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    }
}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "android"
        const val jvm = "jvm"
    }

    object KSP {
        const val ksp = "com.google.devtools.ksp"
    }

    object Navigation {
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {
        const val android = "com.google.dagger.hilt.android"
    }
}