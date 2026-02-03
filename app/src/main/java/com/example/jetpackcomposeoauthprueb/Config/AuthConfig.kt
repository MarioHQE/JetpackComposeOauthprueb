package com.example.jetpackcomposeoauthprueb.Config

import android.content.Context
import androidx.core.net.toUri
import net.openid.appauth.AuthorizationServiceConfiguration

class AuthConfig{

    val serviceconfig: AuthorizationServiceConfiguration = AuthorizationServiceConfiguration(
        "https://proyecto-nuevo-aplicacion-keycloak.vs98ze.easypanel.host/realms/springboot-realm-dev/protocol/openid-connect/auth".toUri(),
        "https://proyecto-nuevo-aplicacion-keycloak.vs98ze.easypanel.host/realms/springboot-realm-dev/protocol/openid-connect/token".toUri()
            )



}