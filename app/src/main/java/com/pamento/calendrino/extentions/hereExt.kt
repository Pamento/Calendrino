package com.pamento.calendrino.extentions

// dayId format: yyyy.m.d example: 2023.1.1 or 2023.12.31

fun String.triple(): Triple<Int, Int, Int> {
  val ts = this.split('.')
  return Triple(ts[0].toInt(), ts[1].toInt(), ts[2].toInt())
}

fun String.nextMonth(): String {
  val ts = this.split('.') // year, month, day
  val month = if ("12" == ts[1]) "1" else ts[1].toInt().inc().toString()
  return "${if (month == "1") ts[0].toInt().inc().toString() else ts[0]}.$month.1"
}

fun String.prevMonth(): String {
  val ts = this.split('.') // year, month, day
  val month = if ("1" == ts[1]) "12" else ts[1].toInt().dec().toString()
  return "${if (month == "12") ts[0].toInt().dec().toString() else ts[0]}.$month.1"
}
