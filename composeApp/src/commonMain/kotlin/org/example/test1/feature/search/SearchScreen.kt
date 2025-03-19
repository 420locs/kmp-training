package org.example.test1.feature.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import org.example.test1.utils.throttleClick

@Composable
internal fun SearchScreen(navController: NavController, keyword: String) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .throttleClick(onClick = navController::navigateUp),
        textAlign = TextAlign.Center,
        text = keyword
    )
}