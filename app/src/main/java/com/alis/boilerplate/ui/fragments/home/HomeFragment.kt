package com.alis.boilerplate.ui.fragments.home

import androidx.fragment.app.Fragment
import com.alis.boilerplate.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
}