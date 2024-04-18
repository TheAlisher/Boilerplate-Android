package com.alish.boilerplate.data.core.utils

import android.webkit.MimeTypeMap
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File

/**
 * Converts the response body to a specific API error type.
 *
 * @receiver [ResponseBody] - The response body.
 * @return [T] - The API error object.
 * @throws NullPointerException if the response body cannot be converted.
 */
internal inline fun <reified T> ResponseBody?.toApiError(): T {
    return this?.let { jsonClient.decodeFromString<T>(it.string()) } ?: throw NullPointerException(
        "JsonUtil cannot convert fromJson: ${T::class.java.simpleName}"
    )
}

/**
 * Get non-nullable body from network request
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * override fun fetchFoo() = doNetworkRequestWithMapping {
 *     service.fetchFoo().onSuccess { data ->
 *         make something with data
 *     }
 * }
 * ```
 *
 * @see Response.body
 * @see let
 */
inline fun <T : Response<S>, S> T.onSuccess(block: (S) -> Unit): T {
    this.body()?.let(block)
    return this
}

/**
 * Convert [File] to [MultipartBody.Part]
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * override fun uploadAvatar(avatar: String) = doNetworkRequest {
 *     val file = File(Uri.parse(avatar).path!!)
 *     service.uploadAvatar(file.toMultipartBodyPart("avatar"))
 * }
 * ```
 *
 * @receiver [File]
 *
 * @param formDataName set name for [MultipartBody.Part.createFormData]
 *
 * @return [MultipartBody.Part]
 *
 * @see asRequestBody
 * @see MimeTypeMap
 * @see toMediaTypeOrNull
 */
fun File.toMultipartBodyPart(
    formDataName: String
) = MultipartBody.Part.createFormData(
    name = formDataName,
    filename = name,
    body = asRequestBody(
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)?.toMediaTypeOrNull()
    )
)