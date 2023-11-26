package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MonthContainer() {
  Box(modifier = Modifier.fillMaxWidth()) {
    AllWeekNamesBox()
  }
}