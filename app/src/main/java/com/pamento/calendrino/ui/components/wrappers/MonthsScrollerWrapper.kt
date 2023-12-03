package com.pamento.calendrino.ui.components.wrappers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pamento.calendrino.ui.components.AllWeekNamesBox
import com.pamento.calendrino.ui.components.MonthsScroller

@Composable
fun MonthsScrollerWrapper() {
  Column(modifier = Modifier.fillMaxWidth()) {
    AllWeekNamesBox()
    MonthsScroller()
  }
}