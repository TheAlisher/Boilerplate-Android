package com.alish.boilerplate.common.extensions

import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.hasPermissionCheckAndRequest(
    requestPermissionLauncher: ActivityResultLauncher<String>,
    permission: String
): Boolean {
    return if (
        ContextCompat.checkSelfPermission(
            requireContext(), permission
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        true
    } else {
        requestPermissionLauncher.launch(permission)
        false
    }
}