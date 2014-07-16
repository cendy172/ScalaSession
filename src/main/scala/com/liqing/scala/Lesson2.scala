package com.liqing.scala

object Lesson2 extends App{

  times(2)(println("hello"))

  times(2){
        println("hello")
      }

  println(daysBetweenYearAndMonth(1902, 1))

  def isOrdered[T](x :Array[T])(f:(T, T) => Boolean): Boolean ={
    if(x.isEmpty || x.size == 1) true
    else if(f(x.head, x.tail.head)) false
    else isOrdered(x.tail)(f)
  }

  def times(x: Int)(f: => Unit){
//    (1 to x).foreach(_ => f)

    for(x <- 1 to x){
      f
    }
  }

  def isLeapYear(x: Int): Boolean ={
    x % 400 == 0 || (x % 4 == 0 && x % 100 != 0)
  }

  def parseDate(x: String): (Int, Int, Int) = {
    val strings: Array[Int] = x.split("-").map(_.toInt)
    (strings(0), strings(1), strings(2))
  }

  def daysBetweenYear(year: Int): Int = {
    (1900 until year).map(x => if(isLeapYear(x)) 366 else 365).sum
  }

  def daysBetweenYearAndMonth(year: Int, month: Int): Int = {
    def daysOfMonth(y: Int): Int = {
      if(y == 2 && !isLeapYear(year)) 28
      else if(y == 2 && isLeapYear(year)) 29
      else if((y <= 7 && y % 2 != 0) || (y > 7 && y % 2 == 0)) 31
      else 30
    }
    daysBetweenYear(year) + (1 until month).map(x => daysOfMonth(x)).sum
  }

}
