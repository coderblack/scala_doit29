package cn.doitedu.scala.demos

import scala.io.Source

case class Soldier(id: Int, name: String, age: Int, power: Int)

class SanGuoIterator extends Iterator[Soldier] {
  private val lines: Iterator[String] = Source.fromFile("data/sanguo.txt").getLines()

  override def hasNext: Boolean = lines.hasNext

  override def next(): Soldier = {
    val line = lines.next()
    // 1_张飞:28,100
    val s1  = line.split("_")
    val s2 = s1(1).split(":")
    val s3 = s2(1).split(",")

    Soldier(s1(0).toInt,s2(0),s3(0).toInt,s3(1).toInt)
  }
}

object SanGuoIterator{
  def apply(): SanGuoIterator = new SanGuoIterator()
}

class SanGuoList extends Iterable[Soldier]{
  override def iterator: Iterator[Soldier] = SanGuoIterator()
}

object _13_迭代器 {
  def main(args: Array[String]): Unit = {

    val iter = SanGuoIterator()
    while (iter.hasNext) {
      println(iter.next())
    }

    println("-----------更简洁的iterable-------------------")
    val list = new SanGuoList
    list.foreach(println)
  }
}
