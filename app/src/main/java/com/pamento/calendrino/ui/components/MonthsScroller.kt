package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MonthsScroller() {
  Column(modifier = Modifier.fillMaxWidth()) {
    MonthContainer()
  }
}
