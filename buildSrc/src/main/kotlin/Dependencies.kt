object Dependencies {

    object Lifecycle {
        private const val version = "2.4.1"

        // | for Lifecycles only (without ViewModel or LiveData)
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

        // | for ViewModel
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Navigation {
        private const val version = "2.4.1"

        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"

        const val safeArgsGradlePlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
    }

    object Hilt {
        private const val version = "2.40.5"

        const val android = "com.google.dagger:hilt-android:$version"
        const val kapt = "com.google.dagger:hilt-compiler:$version"

        const val androidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }
}