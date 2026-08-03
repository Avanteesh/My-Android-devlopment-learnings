package com.example.learnbottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

data class Friends(
    val name: String, val phone_no: String, val address: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground=true)
@Composable
fun App()  {
    val friends = listOf(
        Friends("nix", "438879", "punjab"),
        Friends("mike", "489398", "delhi"),
        Friends("sally", "498389", "haryana"),
        Friends("micheal", "893895", "delhi")
    )
    var state_value by remember { mutableStateOf(friends[0]) }
    Box(modifier = Modifier.fillMaxSize().padding(2.dp)) {
        BottomSheetScaffold(sheetPeekHeight = 200.dp,  sheetContent = {
            Column(modifier =  Modifier.fillMaxWidth().padding(16.dp)) {
                Text("Name: ${state_value.name}", fontSize = 27.sp, fontWeight = FontWeight.ExtraBold)
                Text("Phone no. ${state_value.phone_no}")
                Text("Address: ${state_value.address}")
            }
        }, sheetContainerColor = Color(255,230,185)) { padding ->
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(padding).background(Color(255,240,225)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier=Modifier.height(25.dp))
                Text("My Friends List", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                LazyColumn(Modifier.padding(15.dp).fillMaxWidth()) {
                    items(friends) { friend ->
                        ListItem(
                            leadingContent = {
                                Icon(
                                    Icons.Default.Person,
                                    null,
                                    modifier = Modifier.size(70.dp),
                                    tint = Color.Magenta
                                )
                            },
                            headlineContent = {
                                Text(friend.name, fontSize = 35.sp, fontWeight = FontWeight.Bold)
                            },
                            supportingContent = {
                                Text(
                                    "Phone No. ${friend.phone_no}",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }, modifier = Modifier.clickable {
                                state_value = friend
                            }, colors = ListItemColors(
                                Color(255, 180, 165),
                                headlineColor = Color.DarkGray,
                                leadingIconColor = Color.Cyan,
                                overlineColor = Color.Magenta,
                                supportingTextColor = Color.Black,
                                trailingIconColor = Color.Black,
                                disabledHeadlineColor =Color.DarkGray,
                                disabledLeadingIconColor = Color.DarkGray,
                                disabledTrailingIconColor = Color.DarkGray,
                            ),
                        )
                    }
                }
            }
        }
    }
}



