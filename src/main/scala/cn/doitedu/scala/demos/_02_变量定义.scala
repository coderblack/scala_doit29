package cn.doitedu.scala.demos

import scala.collection.mutable.ListBuffer

object _02_变量定义 {
  def main(args: Array[String]): Unit = {

    // 定义变量，不需要指定类型
    val x = 5  // 自动推断x的类型是Int类型
    // 也可以显式声明变量的类型
    val y:Int = 6
    val name = "张三"  // 自动推断name的类型是String类型
    val salary:Double = 88.8  // 自动推断为Double类型
    val height = 5.5f   // 自动推断为Float类型
    val marriage = true  // 自动推断为Boolean类型


    // 定义变量的val 和 var 的区别
    val a = 10
    // a = 20  val定义的变量，不能重新赋值，相当于定义了一个常量

    val lst = new ListBuffer[Int]()
    lst.+=(5)  // 这里变的是list中的元素，而lst变量本身并没有发生修改
    lst(0) = 6   // 这里变的是list中的元素，而lst变量本身并没有发生修改
    // lst = new ListBuffer[Int]()  // 这样做，本质上是修改了lst变量


    var b = 100
    b = 200   // var定义的变量，就是我们平常所理解的变量，可以任意重新赋值
    // b = "200" // 虽然scala中定义变量的时候不用指定类型，但不代表它是一个弱类型语言（scala是强类型）


    // 类型转换  ，一般就是调用方法  toXxx
    val d1 = 28.8
    val int1 = d1.toInt

    val s1 = "88"
    val int2 = s1.toInt

    val int3 = 999
    val s2 = int3.toString


    // 算术运算符
    val sum = 3 + 5
    val diff: Double = d1 -3
    val multi = int3 * 80
    val div = int3/99
    val mod = int3 % 5

    // 关系运算符: 返回boolean值结果
    val age = 40
    val isOld = age>60
    val isOld2 = age>=60
    val isYoung = age<40
    val isYoung2 = age<=40

    val grade1 = 3
    val grade2 = 4
    val isSameGrade = grade1 == grade2
    val isNotSameGrade = grade1 != grade2

    // 逻辑运算符: 多个boolean值参与运算，返回的也是boolean
    val res = true && false
    val res2= age>40 && grade1>=3
    val res3= age>40 || grade1>=3
    val res4= age>40 & grade1>=3
    val res5= age>40 | grade1>=3

    // 位运算符
    val sos = 2 << 3
    println(sos)  // 16

    val xox = 8 >> 2  // 8/(2^2) = 2

    val yoy = 8 & 15  //  按位与

    // 赋值
    var score1 = 5
    score1 += 3
    var sos2 = 4
    sos2 <<= 2   // sos2 = sos2<<2

    val zoz = 3 * 4 << 4 - 2  // 优先级：  先乘除，再加减 ，再位运算
    println(zoz)


    // 定义一个变量赋初始值10，再定义一个变量赋值为20，然后，将第一个变量重复值为：变量1+变量2的结果，最后，把结果转成字符串并打印


  }

}
