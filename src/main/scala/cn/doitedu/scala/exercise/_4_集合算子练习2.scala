package cn.doitedu.scala.exercise

import java.io.{BufferedReader, FileReader}

object _4_集合算子练习2 {

  def main(args: Array[String]): Unit = {

    // 读文件
    val br = new BufferedReader(new FileReader("data/wc.txt"))
    var line:String = null
    do(
      line = br.readLine()
    )while(line!=null)

    // 创建数组
    val lines = new Array[String](3)
    lines(0) = "hello spark"


    /**
     * TODO 1. 利用为师上面给的素材，实现：  读文件，并将每一行装入一个数组
     * TODO 2. 利用装好数据的数组，求 wordCount
     */



  }

}
