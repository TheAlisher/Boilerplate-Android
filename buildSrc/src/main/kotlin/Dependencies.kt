object Dependencies {

    object Kotlin {

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"

        const val ksp = "com.google.devtools.ksp"
        const val kspVersion = "1.6.10-1.0.3"
    }

    // App
    object Core {
        private const val version = "1.7.0"

        const val core = "androidx.core:core-ktx:$version"
    }

    object Activity {
        private const val version = "1.4.0"

        const val activity = "androidx.activity:activity-ktx:$version"
    }

    object Fragment {
        private const val version = "1.4.1"

        const val fragment = "androidx.fragment:fragment-ktx:$version"
    }

    object Lifecycle {
        private const val version = "2.4.1"

        // | for Lifecycles only (without ViewModel or LiveData)
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

        // | for ViewModel
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Navigation {
        const val version = "2.4.1"

        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {
        const val version = "2.41"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val plugin = "com.google.dagger.hilt.android"
    }

    // Data
    object Retrofit2 {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp3 {
        private const val version = "5.0.0-alpha.4"

        const val bom = "com.squareup.okhttp3:okhttp-bom:$version"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Room {
        private const val version = "2.4.1"

        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"

        // | optional - Kotlin Extensions and Coroutines support for Room
        const val supportKotlinExtensionsAndCoroutines = "androidx.room:room-ktx:$version"
    }

    object Paging3 {
        private const val version = "3.1.0"

        const val runtime = "androidx.paging:paging-runtime-ktx:$version"
    }
}