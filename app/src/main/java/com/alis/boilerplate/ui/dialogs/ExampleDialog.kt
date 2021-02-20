package com.alis.boilerplate.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import com.alis.boilerplate.databinding.DialogExampleBinding

class ExampleDialog : AppCompatDialogFragment() {

    private var _binding: DialogExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogExampleBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(activity)
            .setView(binding.root)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}