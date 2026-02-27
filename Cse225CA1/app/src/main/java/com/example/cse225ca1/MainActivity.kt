package com.example.cse225ca1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.cse225ca1.ui.theme.Cse225CA1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomePage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomePage() {
    val context = LocalContext.current
    var open by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Home Page", fontSize = 24.sp)
                        Spacer(modifier = Modifier.fillMaxWidth(0.7f))
                        IconButton(onClick = {open=true}) {
                            Icon(Icons.Default.Menu, null)
                            DropdownMenu(expanded = open, onDismissRequest = {open=false}) {
                                DropdownMenuItem(text = { Text("Profile") }, onClick = {
                                    context.startActivity(Intent(context, PersonActivity::class.java))
                                    open=false
                                })
                                DropdownMenuItem(text={Text("Logout")}, onClick = {open=false})
                            }
                        }
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.Gray,
                    actionIconContentColor = Color.Gray,
                    navigationIconContentColor = Color.Gray
                )
            )
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Home")
        }
    }
}




