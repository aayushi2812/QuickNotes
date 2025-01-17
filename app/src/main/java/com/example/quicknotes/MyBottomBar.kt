package com.example.quicknotes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color

@Composable
fun MyBottomBar(onNavigate: (String) -> Unit) {

    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        NavigationItem("Home", Icons.Default.Home),
        NavigationItem("Create", Icons.Default.Add)
    )

    NavigationBar(
        containerColor = Color(0xFFD99D81),
        contentColor = Color.Black
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index
                    if(selectedItem==0){
                        onNavigate("home")
                    }else{
                        onNavigate("create")
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) }
            )
        }
    }
}

//@Composable
//fun NavigationBarScreen() {
//    Scaffold(
//        bottomBar = { MyBottomBar() }
//    ) { innerPadding ->
//        // Your screen content here
//        Text(
//            text = "Current Screen Content",
//            modifier = Modifier.padding(innerPadding)
//        )
//    }
//}

data class NavigationItem(val label: String, val icon: ImageVector)
