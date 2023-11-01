package com.pamento.calendrino.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.difference
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@Composable
fun Day(
  dayNumber: Number,
  dayToDay: Boolean,
  important: Boolean
) {
  Surface(
    modifier = Modifier.then(if (dayToDay) Modifier.border(2.dp, Color.Yellow) else Modifier)
  ) {
    Box(
      modifier = Modifier.size(48.dp),
      contentAlignment = Alignment.Center) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(text = dayNumber.toString())
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.Center) {
          Donut(important)
        }
      }
    }
  }
}

@Preview("Regular colors")
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDay() {
  CalendrinoTheme {
    Surface {
      Day(dayNumber = 17, dayToDay = false, important = false)
    }
  }
}

@Composable
fun Donut(important: Boolean) {
  var signalColor = if (important) Color.Red else MaterialTheme.colorScheme.onPrimary
  Surface(
    modifier = Modifier.size(8.dp),
    color = signalColor,
    shape = object : Shape {
      override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
      ): Outline  {
          val thickness = size.height / 4
          val p1 = Path().apply {
            addOval(Rect(0f, 0f, size.width - 1, size.height - 1))
          }
          val p2 = Path().apply {
            addOval(
              Rect(
                thickness,
                thickness,
                size.width - 1 - thickness,
                size.height - 1 - thickness
              )
            )
          }
          val p3 = Path()
          p3.op(p1, p2, PathOperation.Difference)
          return Outline.Generic(p3)
        }
    }
  ) {
  }
}
