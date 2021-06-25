package com.alish.boilerplate.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import com.alish.boilerplate.databinding.DialogExampleBinding

class ExampleDialog : AppCompatDialogFragment() {

    private var _binding: DialogExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogExampleBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)
            .setView(binding.root)
            .create()

        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObservers()

        return builder
    }

    private fun initialize() {
    }

    private fun setupViews() {
    }

    private fun setupListeners() {
    }

    private fun setupRequests() {
    }

    private fun setupObservers() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}