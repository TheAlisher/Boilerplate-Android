package com.alis.boilerplate.extensions.permissions

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

@Deprecated("", ReplaceWith("", ""), DeprecationLevel.WARNING)
fun Fragment.hasPermission(permission: String, requestCode: Int): Boolean {
    return if (ContextCompat.checkSelfPermission(
            requireContext(), permission
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        true
    } else {
        requestPermissions(arrayOf(permission), requestCode)
        false
    }
}

@Deprecated("", ReplaceWith("", ""), DeprecationLevel.WARNING)
fun Fragment.isGranted(grantResults: IntArray, permission: String): Int {
    return if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
        PackageManager.PERMISSION_GRANTED
    } else {
        if (!shouldShowRequestPermissionRationale(permission)) {
            PermissionsConstants.PERMISSION_DENIED_WITH_DO_NOT_ASK_AGAIN
        } else {
            PackageManager.PERMISSION_DENIED
        }
    }
}