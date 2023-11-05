package com.pamento.calendrino.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pamento.calendrino.ui.theme.CalendrinoTheme

@Composable
fun CalendrinoAppBar(
  monthName: String,
  year: String,
  modifier: Modifier = Modifier,
  navigationIcon: @Composable (() -> Unit)? = null,
  actions: @Composable RowScope.() -> Unit = {},
  backgroundColor: Color = MaterialTheme.colorScheme.surface,
  contentColor: Color = contentColorFor(backgroundColor),
  elevation: Dp = 4.dp
) {
  Surface(
    color = backgroundColor,
    modifier = modifier
  ) {
    Box(
      modifier = Modifier.fillMaxWidth()
        .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 12.dp)) {
      Row {
        Text(
          text = monthName,
          color = MaterialTheme.colorScheme.onSurface,
          style = MaterialTheme.typography.titleLarge,
          overflow = TextOverflow.Ellipsis
          )
        Text(
          text = ", $year",
          color = MaterialTheme.colorScheme.onSurface,
          style = MaterialTheme.typography.titleLarge,
          overflow = TextOverflow.Ellipsis
        )
      }
    }
  }
}

@Preview("Calendrino App Bar")
@Preview("Calendrino App Bar (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Calendrino App Bar (big font)", fontScale = 1.5f)
// @Preview("Calendrino App Bar (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewCalendrinoAppBar() {
  CalendrinoTheme {
    CalendrinoAppBar(monthName = "January", year = "2024")
  }
}