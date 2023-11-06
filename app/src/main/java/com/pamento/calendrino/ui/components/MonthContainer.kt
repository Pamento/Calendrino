package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pamento.calendrino.R

@Composable
fun MonthContainer() {
  Box(modifier = Modifier.fillMaxWidth()) {
    Column {
      DayName(dayName = stringResource(id = R.string.day_week_1))
      DayName(dayName = stringResource(id = R.string.day_week_2))
      DayName(dayName = stringResource(id = R.string.day_week_3))
      DayName(dayName = stringResource(id = R.string.day_week_4))
      DayName(dayName = stringResource(id = R.string.day_week_5))
      DayName(dayName = stringResource(id = R.string.day_week_6))
      DayName(dayName = stringResource(id = R.string.day_week_7))
    }
  }
}