package com.alish.boilerplate.ui.fragments.request

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alish.boilerplate.data.network.resource.Resource

class RequestFragment : Fragment() {

    private val viewModel: RequestViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequests()
    }

    private fun setupRequests() {
        viewModel.fetchFoo().observe(viewLifecycleOwner, {
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
        })
    }
}