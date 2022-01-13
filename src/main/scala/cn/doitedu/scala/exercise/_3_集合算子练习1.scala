package cn.doitedu.scala.exercise

case class Ord(id: Int, name: String = "")

object 集合算子练习1 {
  def main(args: Array[String]): Unit = {

    /**
     * 1. 创建一个整数数组（数组1），装入10个整数
     */
    val arr1 = Array(1, 3, 5, 2, 6, 8, 4, 9, 8, 3)

    // 打印出数组的长度
    println(arr1.length)

    // 打印出数组中的每一个元素
    arr1.foreach(e => println(e))
    arr1.foreach(println(_))
    arr1.foreach(println)

    // 对数组1 ，做映射处理： 每个元素*10 ，得到新数组，并打印出新数组
    // arr1.map( (x:Int)=>{x*10}    )
    val arr2 = arr1.map(_ * 10)
    arr2.foreach(println)

    // 对数组1 ，做映射处理： 每个元素*10 > 100 ? 1:0 ，得到新数组，并打印出新数组
    val arr3 = arr1.map((x: Int) => {
      val tmp = x * 10
      if (tmp > 100) 1 else 0
    })
    arr3.foreach(println)

    // 对数组1，做映射处理： 每个元素映射成 ord对象，ord对象的id就是当前这个元素,并打印结果数组
    //arr1.map( (x:Int)=>{ Ord(x) }  )
    val arr4 = arr1.map(Ord(_))
    arr4.foreach(println)

    /*
     * 2. 创建一个数组，数组中的元素是一个一个的字符串数组，并装入一些数据
     */
    println("------------------------")
    val dualArr = Array(Array("a","a","b"),Array("a","c","b"),Array("c","c","d","d"))
    // 对数组压平
    val flattenedArr = dualArr.flatten
    println(flattenedArr.mkString(","))

    // 对数组按相同元素分组，并打印
    val grouped: Map[String, Array[String]] = dualArr.flatten.groupBy(x => x)
    // 打印得好看一点
    val toPrintMap: Map[String, String] = grouped.map(tp => (tp._1, tp._2.mkString("[", ",", "]")))
    println(toPrintMap)

    // 求每一组的长度，并打印
    val cntMap: Map[String, Int] = grouped.map(tp => (tp._1, tp._2.length))
    println(cntMap)


  }

}
