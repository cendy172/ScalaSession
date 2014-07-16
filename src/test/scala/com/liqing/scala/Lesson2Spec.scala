package com.liqing.scala

import org.scalatest.{FlatSpec}

class Lesson2Spec extends FlatSpec {

  it should "array is sorted" in {
    assert(Lesson2.isOrdered(Array[Int]())((a, b) => a > b))
    assert(Lesson2.isOrdered(Array(1, 2, 3))((a, b) => a > b))
    assert(Lesson2.isOrdered(Array(1, 3, 3))(_ > _))
    assert(Lesson2.isOrdered(Array(1.0, 3.1, 3.2))(_ > _))
  }

  it should "array is not ordered" in {
    assert(!Lesson2.isOrdered(Array(3, 3, 2))((a, b) => a > b))
  }

  it should "leap year" in {
    assert(Lesson2.isLeapYear(2000))
    assert(Lesson2.isLeapYear(1904))
  }

  it should "not leap year" in {
    assert(!Lesson2.isLeapYear(1900))
  }

  it should "split date" in {
    assert(Lesson2.parseDate("1990-10-28") ==(1990, 10, 28))
  }

  it should "get the days between 1900-01-01 and year" in {
    assert(Lesson2.daysBetweenYear(1902) == 730)
  }

  it should "get the days between 1900-01-01 and year with month" in {
    assert(Lesson2.daysBetweenYearAndMonth(1902, 1) == 730 )
    assert(Lesson2.daysBetweenYearAndMonth(1902, 2) == 761 )
    assert(Lesson2.daysBetweenYearAndMonth(1902, 3) == 789 )
  }

}
