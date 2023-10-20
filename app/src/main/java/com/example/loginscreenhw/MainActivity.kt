package com.example.loginscreenhw

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.loginscreenhw.ui.theme.LoginScreenHWTheme

const val username = "admin"
const val password = "1234"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreenHWTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val usernameText = remember { mutableStateOf("") }
        val passwordText = remember { mutableStateOf("") }

        TextField(value = usernameText.value, onValueChange = { usernameText.value = it })
        TextField(
            value = passwordText.value,
            onValueChange = { passwordText.value = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = {
            if (usernameText.value == username && passwordText.value == password) Toast.makeText(
                context,
                "Login successful!",
                Toast.LENGTH_SHORT
            ).show()
            else Toast.makeText(context, "Username or password does not match!", Toast.LENGTH_SHORT)
                .show()
        }) {
            Text(text = "Log In")
        }
    }
}