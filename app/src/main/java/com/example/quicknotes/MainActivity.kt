package com.example.quicknotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.quicknotes.ui.theme.QuickNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickNotesTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        MyBottomBar( onNavigate = { path ->
                            navController.navigate(path)
                        })
                    },
                    topBar = {
                        Box(
                            modifier = Modifier.fillMaxWidth().background(Color(0xFFD99D81)),
                            contentAlignment = Alignment.Center,
                            ) {
                            Text(
                                text = "Quick Notes",
                                fontSize = 30.sp,
                                modifier = Modifier.padding(30.dp).height(40.dp).size(200.dp)
                            )
                        }
                    },
                    floatingActionButton = { MyFavButton(onNavigate = {path ->
                        navController.navigate("create")
                    }) },
                    floatingActionButtonPosition = FabPosition.End
                ){
                    innerPadding ->
                    Column (modifier = Modifier.padding(innerPadding).fillMaxSize())
                    {
                        QuickNotesNav(navController)
                    }
                }
            }
        }
    }
}

