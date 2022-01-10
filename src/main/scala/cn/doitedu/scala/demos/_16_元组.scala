package cn.doitedu.scala.demos

object _16_元组 {
  def main(args: Array[String]): Unit = {

    // Tuple（元组）是scala中为了开发方便，专门弄出来一个非集合非数组但是可以装多个数据的东东
    val tp2: Tuple2[Int, Int] = (1,2)
    val tp3: Tuple3[Int,String,Double] = (1,"a",3.5)

    // 元组的类型的语法糖表达方法
    val tp12 : (Int,Int) = (1,2)
    val tp13 : (Int,String,Double) = (1,"a",3.5)

    // 元组中的元素个数最大到22个，因为TupleX类型只有Tuple2 ->  Tuple22

    // 元组取值
    println(tp13._1)
    println(tp13._2)
    println(tp13._3)


  }

}
