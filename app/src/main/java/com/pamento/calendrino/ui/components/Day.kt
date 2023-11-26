package com.pamento.calendrino.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@Composable
fun Day(
  dayNumber: Number,
  isToday: Boolean,
  important: Boolean,
  isSelected: Boolean
) {
  val surfaceColor = if (isToday) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.surfaceVariant
  val impEventColor = if (important) Color.Red else surfaceColor
  val todayColor = if (isSelected) MaterialTheme.colorScheme.secondary else surfaceColor
  Surface {
    Box(
      // TODO 28/11: size must be dynamic or gird
      modifier = Modifier.size(48.dp).background(surfaceColor).border(2.dp, todayColor, RoundedCornerShape(18)),
      contentAlignment = Alignment.Center) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(text = dayNumber.toString(), color = MaterialTheme.colorScheme.onSurface)
        Row(
          modifier = Modifier.width(16.dp),
          horizontalArrangement = Arrangement.Center) {
          Rectangle(color = if (isSelected) impEventColor else surfaceColor)
          Rectangle(modifier = Modifier.weight(0.3f),
            color = Color.Transparent)
          Rectangle(modifier = Modifier.weight(0.7f),
            color = if (isSelected) impEventColor else surfaceColor)
        }
      }
    }
  }
}

@Composable
fun DayName(
  dayName: String,
) {
  Box(modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)) {
    Text(
      text = dayName,
      color = MaterialTheme.colorScheme.onSurface,
      style = MaterialTheme.typography.labelSmall,
    )
  }
}

@Composable
fun Rectangle(color: Color,
              modifier: Modifier = Modifier) {
  Box(
    modifier = modifier.composed {
      size(2.dp)
        .clip(RectangleShape)
        .background(color)
    }
  )
}

@Preview("Regular colors")
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDay() {
  CalendrinoTheme {
    Surface {
      Day(dayNumber = 17, isToday = false, important = true, isSelected = true)
    }
  }
}

@Preview("Regular colors")
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDayName() {
  CalendrinoTheme {
    DayName(dayName = "M")
  }
}
