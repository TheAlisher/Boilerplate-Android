package com.alish.boilerplate.ui.fragments.koin

import androidx.fragment.app.Fragment
import com.alish.boilerplate.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinFragment : Fragment(R.layout.fragment_koin) {

    private val viewModel: KoinViewModel by viewModel()
}