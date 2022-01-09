package cn.doitedu.scala.demos

import java.util.Random
import scala.collection.immutable

object _03_流程控制语法 {
  def main(args: Array[String]): Unit = {

    // 定义一个变量，赋值为一个随机数
    // 然后判断，变量值如果<10,则打印 多易教育很伟大
    // 如果 >=10  and  <100, 则打印  伟大的多易教育
    // 如果是其他， 则打印  多易教育伟大的涛哥

    val x = new Random().nextInt(10000)
    println(x)
    if (x < 10) {
      println("多易教育很伟大")
    } else if (x >= 10 && x < 100) {
      println("伟大的多易教育")
    } else {
      println("多易教育伟大的涛哥")
    }

    // scala中的if语句，跟java不同的是，if语句块可以有返回值
    val y = new Random().nextInt(100)

    val res: Int = if (y < 10) {
      println("haha")
      5
    } else if (y >= 10 && y < 100) {
      6
    } else {
      7
    }


    println("哈哈哈")


    /**
     * while 循环
     */
    var i = 0
    while (i < 4) {
      if (i % 2 == 0) println(i)
      i += 1
    }


    /**
     * do while
     */
    val j = 11
    do {
      println(j)
    } while (j < 10)

    /**
     * for 循环
     * 跟java中的增强for循环类似
     */
    for (i <- 1 to 10) {
      println(i)
    }

    println("--------------------华丽的分割线---------------------")

    /**
     * 打印一个乘法表
     * 1*1 = 1
     * 1*2 = 2   2*2=4
     * 1*3 = 3   2*3=6  3*3=9
     */
    /*for(i <- 1 to 9){
      for(j<- 1 to i){
        print(i+ " X " + j + " = " +(i*j) + "\t")
      }
      println()
    }*/

    for (i <- 1 to 9; j <- 1 to i) {
      print(i + " X " + j + " = " + (i * j) + "\t")
      if (j == i) println
    }


  }

}
