package com.example.jetpackcomposeoauthprueb.Service

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import com.example.jetpackcomposeoauthprueb.Config.AuthConfig
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.ResponseTypeValues


class AuthManager(context: Context) {
    private val authserviceconfig = AuthConfig().serviceconfig
    private val authService = AuthorizationService(context);

    fun login(): Intent {
        val authrequest = AuthorizationRequest.Builder(
            authserviceconfig,
            "android-client",
            ResponseTypeValues.CODE,
            "com.example.jetpackcomposeoauthprueb:/oauth2redirect".toUri()
        ).setScopes("openid", "profile", "email").build()


        return authService.getAuthorizationRequestIntent(authrequest)
    }


}