package com.alis.boilerplate.base

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithViewModel<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : BaseFragment<Binding>(layoutId) {

    protected abstract val viewModel: ViewModel
}