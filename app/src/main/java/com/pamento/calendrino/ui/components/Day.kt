package com.pamento.calendrino.ui.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import com.pamento.calendrino.data.DayData
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@Composable
fun Day(
  modifier: Modifier = Modifier,
  dayData: DayData
) {
  val surfaceColor = if (dayData.isToday) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.surfaceVariant
  val impEventColor = if (dayData.important) Color.Red else surfaceColor
  val todayColor = if (dayData.isSelected) MaterialTheme.colorScheme.secondary else surfaceColor
  Surface {
    Box(
      // TODO 28/11: size must be dynamic or gird
      modifier = modifier.background(surfaceColor).border(2.dp, todayColor, RoundedCornerShape(18)),
      contentAlignment = Alignment.Center) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(text = dayData.day.toString(), color = MaterialTheme.colorScheme.onSurface)
        Row(
          modifier = Modifier.width(16.dp),
          horizontalArrangement = Arrangement.Center) {
          Rectangle(color = if (dayData.isSelected) impEventColor else surfaceColor)
          Rectangle(modifier = Modifier.weight(0.3f),
            color = Color.Transparent)
          Rectangle(modifier = Modifier.weight(0.7f),
            color = if (dayData.isSelected) impEventColor else surfaceColor)
        }
      }
    }
  }
}

@Composable
fun DayName(
  modifier: Modifier = Modifier,
  dayName: String,
) {
  Box(modifier = modifier.padding(bottom = 8.dp),
    contentAlignment = Alignment.Center) {
    Text(
      text = dayName,
      color = MaterialTheme.colorScheme.onSurface,
      style = MaterialTheme.typography.labelSmall,
    )
  }
}

@SuppressLint("UnnecessaryComposedModifier")
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
      Day(modifier = Modifier.width(48.dp),
        DayData(year = "2023", month = "12", day = 17, dayOfWeek = 1, weekOfYear = 46))
    }
  }
}

@Preview("Regular colors", showBackground = true)
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDayName() {
  CalendrinoTheme {
    DayName(dayName = "M")
  }
}
