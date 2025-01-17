package com.example.quicknotes

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MyFavButton(onNavigate : (String)->Unit){
    var context = LocalContext.current

    FloatingActionButton(onClick = {
        onNavigate("create")
        Toast.makeText(context,"Fab clicked", Toast.LENGTH_SHORT).show()

    } , content = {
        Icon(Icons.Default.Add, contentDescription = "add new")
    })
}