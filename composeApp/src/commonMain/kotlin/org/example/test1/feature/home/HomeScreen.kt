package org.example.test1.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.example.test1.Greeting
import org.example.test1.feature.search.SearchNavigation
import org.jetbrains.compose.resources.painterResource
import testwebapp.composeapp.generated.resources.Res
import testwebapp.composeapp.generated.resources.compose_multiplatform


@Composable
fun HomeScreen(navController: NavController) {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.clickable {
                        navController.navigate(SearchNavigation(keyword = greeting)){
                            launchSingleTop = true
                        }
                    },
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = null
                )
                Text("Compose: $greeting")
            }
        }
    }
}