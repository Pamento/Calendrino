package com.pamento.calendrino.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.pamento.calendrino.R
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@Composable
fun AllWeekNamesBox() {
  BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
    val weekDaysNames = stringArrayResource(id = R.array.week_days_names)
    val dayNameWidth = maxWidth / 7

    Row(modifier = Modifier.fillMaxWidth()) {
      weekDaysNames.forEach { dayName ->
        DayName(modifier = Modifier.width(dayNameWidth), dayName = dayName)
      }
    }
  }
}

@Preview("Regular colors", showBackground = true)
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAllWeekNamesBox() {
  CalendrinoTheme {
    AllWeekNamesBox()
  }
}
