package com.alish.boilerplate.presentation.ui

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.core.base.BaseFragment
import com.alish.boilerplate.presentation.databinding.FragmentBarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BarFragment : BaseFragment<BarViewModel, FragmentBarBinding>(
    R.layout.fragment_bar
) {

    override val viewModel: BarViewModel by viewModels()
    override val binding by viewBinding(FragmentBarBinding::bind)

    override fun setupRequests() {
        viewModel.fetchBar()
    }

    override fun setupSubscribers() {
        viewModel.barState.collectAsUIState(
            onError = {
                it.setupApiErrors()
            },
            onSuccess = {
                it.name
            }
        )
    }
}