package com.example.demo2


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import demo2.composeapp.generated.resources.Res
import demo2.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.padding(16.dp).background(Color.Red).fillMaxWidth().height(170.dp)) {
                Text("Welcome", modifier = Modifier.padding(16.dp))
                //Image(painter = painterResource(), contentDescription = null)
            }
            Box(modifier = Modifier.padding(16.dp).background(Color.White).fillMaxWidth().height(300.dp)) {
                var username by remember { mutableStateOf("")}
                var password by remember { mutableStateOf("") }
                var showDialog by remember { mutableStateOf(false) }
                Column(modifier = Modifier.padding(16.dp)) {
                    OutlinedTextField(value=username,modifier = Modifier.padding(16.dp).fillMaxWidth(), onValueChange =  {
                          username = it
                    })
                    OutlinedTextField(value=password, modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), onValueChange = {
                        password = it
                    })
                    Button(onClick = { showDialog = true }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Yellow)) {
                        Text("login")
                    }
                    if (showDialog) {
                        Dialog(onDismissRequest = { showDialog = true }) {
                            Column(modifier = Modifier.padding(30.dp).background(Color.White)
                                .border(5.dp, Color.Black).width(90.dp).height(50.dp)) {
                                Text("Your credentials")
                                Text("Username: $username")
                                Text("Password: $password")
                                Button({ showDialog = false }) {
                                    Text("close")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

