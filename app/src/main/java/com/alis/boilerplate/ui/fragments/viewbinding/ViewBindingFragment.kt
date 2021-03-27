package com.alis.boilerplate.ui.fragments.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alis.boilerplate.R
import com.alis.boilerplate.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private var _binding: FragmentViewBindingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ViewBindingPropertyDelegateFragment : Fragment(R.layout.fragment_view_binding) {

    // Using reflection API under the hood and ViewBinding.bind
    private val bindingWithReflection: FragmentViewBindingBinding by viewBinding()

    // Without reflection
    private val bindingWithoutReflection by viewBinding(FragmentViewBindingBinding::bind)
}