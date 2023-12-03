package com.pamento.calendrino.ui.components.wrappers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pamento.calendrino.ui.components.AllWeekNamesBox
import com.pamento.calendrino.ui.components.MonthsScroller

@Composable
fun MonthsScrollerWrapper() {
  Column(modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp, 0.dp, 8.dp, 0.dp)) {
    AllWeekNamesBox()
    MonthsScroller()
  }
}
