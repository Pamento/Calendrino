package com.pamento.calendrino.extentions

fun String.triple(): Triple<Int,Int,Int> {
  val ts = this.split('.')
  return Triple(ts[0].toInt(), ts[1].toInt(), ts[2].toInt())
}