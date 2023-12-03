package com.pamento.calendrino.data

data class DayData(
  val year: String,
  val month: String,
  val day: Int,
  val dayOfWeek: Int,
  val weekOfYear: Int,
  val isToday: Boolean = false,
  val important: Boolean = false,
  val isSelected: Boolean = false
) {
  val id: String = "$year.$month.$day"
}

data class DayWorker(
  val totalDays: Int,
  val year: String,
  val month: String,
  val firstDayOfMonth: Int,
  val weekOfYear: Int,
  var isToday: Int? = null
)
