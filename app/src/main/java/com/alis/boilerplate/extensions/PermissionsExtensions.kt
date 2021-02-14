package com.alis.boilerplate.extensions

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.hasPermission(permission: String, requestCode: Int): Boolean {
    return if (ContextCompat.checkSelfPermission(
            requireContext(), permission
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        true
    } else {
        requestPermissions(
            arrayOf(permission),
            requestCode
        )
        false
    }
}


fun Fragment.isGranted(grantResults: IntArray, permission: String): Int {
    return if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
        PackageManager.PERMISSION_GRANTED
    } else {
        if (!shouldShowRequestPermissionRationale(permission)) {
            69
        } else {
            PackageManager.PERMISSION_DENIED
        }
    }
}