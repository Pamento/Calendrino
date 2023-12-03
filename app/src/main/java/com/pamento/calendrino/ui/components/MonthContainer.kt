package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pamento.calendrino.business.getMonth
import com.pamento.calendrino.data.DayData

@Composable
fun MonthContainer() {
  // ToDo logic of get months
  BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
    val dayBoxSize = maxWidth / 7
    val oneMonth = getMonth()
    var i = 0
    val rowsNumber = if (oneMonth.size % 7 == 0) oneMonth.size / 7 else (oneMonth.size / 7).inc()

    Column {
      // repeat Row for each weekend of the month / how many week it is in this month ?
      repeat(rowsNumber) { w ->
        Row {
          repeat(7) { d ->
            // oneMonth[weekInt].dayOfWeek__ 1 = Monday (see CalendrinoEngine.monthFactory)
            var dayData: DayData? = null

            val j = (w * 7) + (d + 1) // for all Day() case in BoxMonth
            if ((j >= oneMonth[0].dayOfWeek) || (j > 7 && i < oneMonth.size)) {
              dayData = oneMonth[i]
              i += 1
            }
            Day(modifier = Modifier.size(dayBoxSize), dayData)
          }
        }
      }
    }
  }
}
