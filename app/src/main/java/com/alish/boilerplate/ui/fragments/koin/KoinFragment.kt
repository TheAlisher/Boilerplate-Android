package com.alish.boilerplate.ui.fragments.koin

import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinFragment : Fragment() {

    private val viewModel: KoinViewModel by viewModel()
}