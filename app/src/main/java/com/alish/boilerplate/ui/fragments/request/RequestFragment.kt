package com.alish.boilerplate.ui.fragments.request

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.alish.boilerplate.data.resource.Resource
import com.alish.boilerplate.extensions.bindToResource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RequestFragment : Fragment() {

    private val viewModel: RequestViewModel by viewModels()

    private lateinit var progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequests()
    }

    private fun setupRequests() {
        lifecycleScope.launch {
            viewModel.fetchFoo().collect {
                progressBar.bindToResource(it)
                when (it) {
                    is Resource.Loading -> {
                        // …
                    }
                    is Resource.Error -> {
                        // …
                    }
                    is Resource.Success -> {
                        // …
                    }
                }
            }
        }
    }
}