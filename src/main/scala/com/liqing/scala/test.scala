package com.liqing.scala

class Person(val name: String, val age: Int)  {
  override def toString = name + " " + age
}

object Person {
  def apply(name: String, age: Int) = new Person(name, age)
}

object  Main extends App{
  println("Hello Scala")

  val p = Person("liqing", 23)

  println(p.toString)
  println(add(2,5))
  println(add1((x: Int) => x * x, 2 ,5))
  println(add1((x: Int) => x * x * x, 2,5))

  println(sum(square)(2, 5))
  println(recur(2, 5, 0))

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if(a > b) 0 else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
      if(a > b) 0 else f(a) + sum1(f)(a + 1, b)
  }

  def recur(a: Int, b: Int, result: Int): Int = {
    if(a > b) result
    else recur(a, b - 1, result + square(b) )
  }

def add(start: Int, end: Int): Int = {
  var total = 0

  for(x <- start to end){
    total += x * x
  }

  total
}


  def square(num: Int): Int = {
    num * num
  }

  def cube(num: Int): Int = {
    num * num * num
  }

def add1(f: Int => Int, start: Int, end: Int): Int = {
    if(start > end) 0
    else f(start) + add1(f, start + 1 , end)
}


def add2(start: Int, end: Int): Int = {
    if(start > end) 0
    else cube(start) + add2(start + 1 , end)
}


}