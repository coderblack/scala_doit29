package cn.doitedu.scala.demos

import scala.collection.mutable.ListBuffer
import scala.util.Sorting


case class DoitStudent(name:String, age:Int, height:Int)

class StudentOrdering extends Ordering[DoitStudent] {
  override def compare(x: DoitStudent, y: DoitStudent): Int = x.age.compare(y.age)
}

class StudentOrdering2 extends Ordering[DoitStudent] {
  override def compare(x: DoitStudent, y: DoitStudent): Int = x.height.compare(y.height)
}


class StudentOrdering3 extends Ordering[DoitStudent] {
  override def compare(x: DoitStudent, y: DoitStudent): Int = y.height.compare(x.height)
}


case class DoitTeacher(name:String, age:Int, height:Int) extends Ordered[DoitTeacher] {
  // 在java中，本方法名字为 compareTo
  override def compare(that: DoitTeacher): Int = this.age.compare(that.age)
}


object _14_比较器示例 {

  def main(args: Array[String]): Unit = {


    /**
     * Ordering的使用示例
     */
    val arr = Array(DoitStudent("张三",18,180),DoitStudent("李四",19,170),DoitStudent("王五",16,190))

    // Ordering接口，就类似于java中的 Comparator 接口
    Sorting.quickSort(arr)(new StudentOrdering)  // 按age比大小
    println(arr.mkString("[",",","]"))

    Sorting.quickSort(arr)(new StudentOrdering2) // 按height比大小
    println(arr.mkString("[",",","]"))

    Sorting.quickSort(arr)(new StudentOrdering3) // 按height倒序比大小
    println(arr.mkString("[",",","]"))

    /**
     * Ordered的使用示例
     * Ordered类似于java中的Comparable
     * 就是： 要比大小的数据本身，具备比大小的功能
     */
    val teachers = Array(DoitTeacher("张三",18,180),DoitTeacher("李四",19,170),DoitTeacher("王五",16,190))
    Sorting.quickSort(teachers)  // 这里不需要额外传入一个比较器也能通过，因为我们的 DoitTeacher 数据类本身就是“可比较的”


  }
}
