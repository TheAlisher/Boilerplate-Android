package com.alish.boilerplate.ui.fragments.hilt

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alish.boilerplate.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltFragment : Fragment(R.layout.fragment_hilt) {

    private val viewModel: HiltViewModel by viewModels()
}