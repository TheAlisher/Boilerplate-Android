package com.alish.boilerplate.ui.fragments.hilt

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltFragment : Fragment() {

    private val viewModel: HiltViewModel by viewModels()
}