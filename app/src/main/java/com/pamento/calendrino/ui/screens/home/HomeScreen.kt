package com.pamento.calendrino.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.pamento.calendrino.ui.components.CalendrinoAppBar
import com.pamento.calendrino.ui.components.wrappers.MonthsScrollerWrapper
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  monthName: String,
  year: String
) {
  Scaffold(
    topBar = {
      CalendrinoAppBar(monthName = monthName, year = year)
    }
  ) { innerPadding ->
    val modifier = Modifier
      .background(MaterialTheme.colorScheme.primary)
      .padding(innerPadding)
    Surface(
      modifier = modifier
    ) {
      MonthsScrollerWrapper()
    }
  }
}

@Preview("Home screen")
@Preview("Home screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Home screen (big font)", fontScale = 1.5f)
@Preview("Home screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewHomeScreen() {
  CalendrinoTheme {
    HomeScreen(
      monthName = "January",
      year = "2024"
    )
  }
}
