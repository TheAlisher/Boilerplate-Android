package com.alish.boilerplate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alish.boilerplate.presentation.R.id.nav_host_fragment
import com.alish.boilerplate.presentation.R.layout.activity_main
import com.alish.boilerplate.R.navigation.nav_graph
import com.alish.boilerplate.presentation.core.extensions.initNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navController by lazy { initNavController(nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navGraph = navController.navInflater.inflate(nav_graph)
        navController.graph = navGraph
    }
}