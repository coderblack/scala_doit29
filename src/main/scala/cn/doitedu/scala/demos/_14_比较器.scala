package cn.doitedu.scala.demos

import scala.util.Sorting

class Employee(val id:Int,val age:Int,val salary:Int) extends Ordered[Employee] {
  override def compare(that: Employee): Int = this.age - that.age
}

class MyOrdering extends Ordering[Employee] {
  override def compare(x: Employee, y: Employee): Int = x.salary -y.salary
}


object _14_比较器 {
  def main(args: Array[String]): Unit = {

    val e1 = new Employee(1, 28, 10000)
    val e2 = new Employee(2, 18, 24000)
    val e3 = new Employee(3, 38, 25000)
    val e4 = new Employee(4, 26, 22000)

    val seq = List(e1, e2, e3, e4).toArray

    /*Sorting.quickSort(seq)(new MyOrdering)*/


    //seq.sorted


  }
}
