package cn.doitedu.scala.demos

import scala.io.Source

object _20_文件IO {
  def main(args: Array[String]): Unit = {

    // 读data/wc.txt做wordcount
    /*val bufferedSource = Source.fromFile("data/wc.txt")
    val lines = bufferedSource.getLines()*/

    val lines = Source.fromFile("data/wc.txt").getLines()
    val wc: Map[String, Int] = lines
      .flatMap(s=>s.split(" "))
      .map(s=>(s,1))
      .toList
      .groupBy(tp=>tp._1)
      .map(tp=>(tp._1,tp._2.size))


    println(wc)


  }
}
