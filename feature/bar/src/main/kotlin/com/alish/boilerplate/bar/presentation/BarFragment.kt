package com.alish.boilerplate.bar.presentation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.bar.R
import com.alish.boilerplate.bar.databinding.FragmentBarBinding
import com.alish.boilerplate.presentation.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BarFragment : BaseFragment<BarViewModel, FragmentBarBinding>(R.layout.fragment_bar) {

    override val viewModel: BarViewModel by viewModels()
    override val binding by viewBinding(FragmentBarBinding::bind)
}