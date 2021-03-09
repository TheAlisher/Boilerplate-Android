package com.alis.boilerplate.ui.fragments.hilt

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alis.boilerplate.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltFragment : Fragment(R.layout.fragment_hilt) {

    private val viewModel: HiltViewModel by viewModels()
}