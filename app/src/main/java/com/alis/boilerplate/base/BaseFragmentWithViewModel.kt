package com.alis.boilerplate.base

import androidx.annotation.LayoutRes

abstract class BaseFragmentWithViewModel<ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : BaseFragment(layoutId) {

    protected abstract val viewModel: ViewModel
}