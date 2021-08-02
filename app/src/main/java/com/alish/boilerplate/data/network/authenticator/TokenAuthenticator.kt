package com.alish.boilerplate.data.network.authenticator

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        /*
        if (response.request.header("Authorization") != null) {
            return null // Give up, we've already attempted to authenticate.
        }
        */

        val newToken = ""

        return response
            .request
            .newBuilder()
            .header("Authorization", "Bearer $newToken")
            .build()
    }
}