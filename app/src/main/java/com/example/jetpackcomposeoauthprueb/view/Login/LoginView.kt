package com.example.jetpackcomposeoauthprueb.view.Login

import android.content.Intent
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcomposeoauthprueb.Service.AuthManager
import net.openid.appauth.AppAuthConfiguration
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationResponse


@Preview
@Composable()
fun LoginView() {
    val context = LocalContext.current
    val authManager = remember { AuthManager(context) }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),

        ) {


        item {
            Button(
                onClick = {
                    context.startActivity(authManager.login())
                }) {
                Text("Iniciar Sesion")
            }
        }


    }
     fun handleAuthResponse(intent: Intent) {
        val data = intent.data

        val resp = AuthorizationResponse.fromIntent(intent)
        val ex = AuthorizationException.fromIntent(intent)

        if (resp != null) {
            Log.d("AUTH", "Login success")
            intent.data = null
        } else {
            Log.e("AUTH", "Error login", ex)
        }
    }
}


