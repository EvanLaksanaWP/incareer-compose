package com.raion.incareer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.raion.incareer.presentation.navigation.NavGraph
import com.raion.incareer.presentation.ui.theme.IncareerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncareerTheme {
                NavGraph()
            }
        }
    }
}