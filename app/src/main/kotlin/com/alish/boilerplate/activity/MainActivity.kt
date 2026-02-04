package com.alish.boilerplate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import com.alish.boilerplate.R
import com.alish.boilerplate.core.presentation.extensions.ActivityNavControllerProvider
import com.alish.boilerplate.core.presentation.extensions.initNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityNavControllerProvider {

    private val navController by lazy { initNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        // Check start destination
        // when {
        //    isSomething -> {
        //        navGraph.setStartDestination(R.id.some_flow_destination)
        //    }
        //    else -> {
        //        navGraph.setStartDestination(R.id.some_other_flow_destination)
        //    }
        // }
        navController.graph = navGraph
    }

    override fun activityNavController(): NavController = navController
}