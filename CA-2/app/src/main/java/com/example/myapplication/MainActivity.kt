package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator  = rememberNavController()
           NavHost(navigator, startDestination = "home") {
                composable(route = "home") {
                    HomeSignIn(navigator)
                }
                composable(route="login/{username}/{password}/{usertype}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username")
                    val password = backStackEntry.arguments?.getString("password")
                    val usertype = backStackEntry.arguments?.getString("usertype")
                    Login(navController = navigator, username, password, usertype)
                }
            }
        }
    }
}

@Composable
fun Login(navController: NavController, username: String?, password: String?, userType: String?) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("login", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Text("Username: $username", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Password: $password", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text("userType: $userType", fontSize = 40.sp)
    }
}

@Composable
fun HomeSignIn(navigator: NavController) {
    val userTypes = listOf("student", "admin")
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var usertype by remember { mutableStateOf(0) }
    var termsAccepted by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("sign in")
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value=username,
            onValueChange = { username = it },
            placeholder = { Text("Username") },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth().height(30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value=password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().height(30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            RadioButton(
                selected = (usertype == 0),
                onClick = { usertype = 0}
            )
            Text("$userTypes[0]")
            RadioButton(
                selected = (usertype == 1),
                onClick = { usertype = 1}
            )
            Text("$userTypes[1]")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = { termsAccepted = !termsAccepted },
            )
            Text("I Accept terms and conditions")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            if (username.length > 4 && password.length > 6 && termsAccepted) {
                navigator.navigate("login/$username/$password/${userTypes[usertype]}")
            }
        }) {
            Text(text = "Sign In")
        }
    }
}

