package com.pamento.calendrino.business

import com.pamento.calendrino.data.DayData
import com.pamento.calendrino.data.DayWorker
import com.pamento.calendrino.extentions.triple
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

fun getMonth(dayId: String? = null): List<DayData> {
  val cldr = Calendar.getInstance()
  var isToday = false

  dayId?.let {
    val (year: Int, month: Int, day: Int) = it.triple()
    cldr.set(YEAR, year)
    cldr.set(MONTH, month - 1)
  } ?: run {
    isToday = true
    val dayOfMont = cldr.get(DAY_OF_MONTH)
  }

  val totalDaysInMonth: Int = cldr.getActualMaximum(DAY_OF_MONTH)
  cldr.set(DAY_OF_MONTH, 1)
  cldr.timeInMillis // to avoid problems getTime make set changes apply

  val dayObject = DayWorker(
    totalDays = totalDaysInMonth,
    year = cldr.get(YEAR).toString(),
    month = cldr.get(MONTH).toString(),
    firstDayOfMonth = cldr.get(Calendar.DAY_OF_WEEK),
    weekOfYear = cldr.get(Calendar.WEEK_OF_YEAR),
    isToday = isToday,
  )

  return monthFactory(dayObject)
}

private fun monthFactory(dayWorker: DayWorker): List<DayData> {
  val allMonth = mutableListOf<DayData>()
  var dayOfWeekCycle = dayWorker.firstDayOfMonth
  var weekOfYearCycle = dayWorker.weekOfYear - 1 // Sunday = 1

  repeat(dayWorker.totalDays) {
    val day = DayData(
        year = dayWorker.year,
        month = dayWorker.month,
        day = it + 1, // 'it' = index = 0
        dayOfWeek = dayOfWeekCycle,
        weekOfYear = weekOfYearCycle,
        isToday = dayWorker.isToday
      )

    if (dayOfWeekCycle == 7) {
      dayOfWeekCycle = 1
      weekOfYearCycle += 1
    } else {
      dayOfWeekCycle += 1
    }

    allMonth.add(day)
  }
  return allMonth
}
