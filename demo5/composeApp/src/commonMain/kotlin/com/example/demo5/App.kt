package com.example.demo5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Switch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.input.VisualTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(modifier = Modifier.wrapContentSize(Alignment.Center).fillMaxSize().safeContentPadding(),horizontalAlignment = Alignment.CenterHorizontally)  {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordHidden by remember { mutableStateOf(true) }
            Spacer(Modifier.height(32.dp))
            Text("Login Form", fontSize = 40.sp)
            Spacer(modifier = Modifier.height(64.dp))
            OutlinedTextField(value=email, modifier = Modifier.fillMaxWidth(0.65f),onValueChange = {
                email = it
            }, label = {Text("email")}, placeholder = {Text("Please enter your email")})
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value=password, modifier = Modifier.fillMaxWidth(0.65f),
                onValueChange = {password = it},
                label = {Text("password")}, placeholder = {Text("Please enter your password")},
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = if (passwordHidden) KeyboardType.Password else KeyboardType.Text),
                trailingIcon = {
                    TextButton(onClick = {  passwordHidden = !passwordHidden }) {
                        Text(if (passwordHidden) "show" else "hide", color = Color.Blue)
                    }
                }
            )
            Row(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
                val genders = listOf("Male", "Female", "Other")
                Text("Gender")
                Spacer(Modifier.width(2.dp))
                Row(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
                    var isselected by remember { mutableStateOf(0) }
                    RadioButton(selected=(isselected == 0), onClick = {
                        isselected = 0
                    })
                    Text(genders[0])
                    RadioButton(selected=(isselected == 1), onClick = {
                        isselected = 1
                    })
                    Text(genders[1])
                    RadioButton(selected=(isselected == 2), onClick = {
                        isselected = 2
                    })
                    Text(genders[2])
                }
            }
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Red), modifier = Modifier.fillMaxWidth(fraction = 0.4f).height(50.dp)) {
                Text("login", fontSize = 20.sp)
            }
        }
    }

}