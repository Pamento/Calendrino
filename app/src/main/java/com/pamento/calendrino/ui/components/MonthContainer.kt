package com.pamento.calendrino.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pamento.calendrino.business.getMonth

@Composable
fun MonthContainer() {
  // ToDo logic of get months
  Box(modifier = Modifier.fillMaxWidth()) {
    val oneMonth = getMonth()
    var counter = 0

    Column {
      // repeat Row for each weekend of the month / how many week it is in this month ?
      repeat(oneMonth.size/7) {
        Row(modifier = Modifier.fillMaxWidth()) {
          repeat(7) {
            Day(oneMonth[counter])
            counter += 1
          }
        }
      }
    }
  }
}