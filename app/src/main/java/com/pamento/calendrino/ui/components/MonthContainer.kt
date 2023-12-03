package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pamento.calendrino.business.getMonth

@Composable
fun MonthContainer() {
  // ToDo logic of get months
  BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
    val dayBoxSize = maxWidth / 7
    val oneMonth = getMonth()
    var counter = 0
    val rowsNumber = oneMonth.size / 7 // TODO need a Day to be empty case with Day colors
//    val rowsNumber = if (oneMonth.size % 7 == 0) oneMonth.size / 7 else (oneMonth.size / 7).inc()

    Column {
      // repeat Row for each weekend of the month / how many week it is in this month ?
      repeat(rowsNumber) {
        Row {
          repeat(7) {
            Day(modifier = Modifier.size(dayBoxSize), oneMonth[counter])
            counter += 1
          }
        }
      }
    }
  }
}
