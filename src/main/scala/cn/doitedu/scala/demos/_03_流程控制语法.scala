package cn.doitedu.scala.demos

import java.util.Random

object _03_流程控制语法 {
  def main(args: Array[String]): Unit = {

    // 定义一个变量，赋值为一个随机数
    // 然后判断，变量值如果<10,则打印 多易教育很伟大
    // 如果 >=10  and  <100, 则打印  伟大的多易教育
    // 如果是其他， 则打印  多易教育伟大的涛哥

    val x = new Random().nextInt(10000)
    println(x)
    if(x<10){
      println("多易教育很伟大")
    }else if (x>=10 && x<100){
      println("伟大的多易教育")
    }else{
      println("多易教育伟大的涛哥")
    }

    // scala中的if语句，跟java不同的是，if语句块可以有返回值
    val y = new Random().nextInt(100)

    val res:Int = if(y<10){
      println("haha")
      return 5
    }else if (y>=10 && y<100){
      return 6
    }else{
      return 7
    }

    println(res)



  }

}
