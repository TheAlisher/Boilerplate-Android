package com.alish.boilerplate.bar.presentation

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.bar.R
import com.alish.boilerplate.bar.databinding.FragmentBarBinding
import com.alish.boilerplate.presentation.core.base.BaseFragment
import com.alish.boilerplate.presentation.core.extensions.activityNavController
import com.alish.boilerplate.presentation.core.extensions.navigateSafely
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BarFragment : BaseFragment<BarViewModel, FragmentBarBinding>(R.layout.fragment_bar) {

    override val viewModel: BarViewModel by viewModels()
    override val binding by viewBinding(FragmentBarBinding::bind)

    override fun initialize() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(500)

            // TODO: Navigate to FooFragment – multi-module navigation

            // activityNavController().navigateSafely()
        }
    }
}