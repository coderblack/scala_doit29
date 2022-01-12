package cn.doitedu.scala.demos

object _18_Iterator上的高阶api {
  def main(args: Array[String]): Unit = {

    val arr = Array(1,2,3,4,5)

    val iter1 = arr.iterator
    // 迭代器上有类似于TraversableLike上的高阶api
    val iter2: Iterator[Int] = iter1.map(ele=> ele * 10)
    val iter3: Iterator[Int] = iter2.map(ele => ele + 100)
    val iter4 = iter3.map(ele => ele - 50)

    // 上面的迭代器链条，就形成了如下的数据处理流程（函数运算链）：
    // 从数组中取一个数据 -> f1: 数据*10  ->  f2:数据+100 -> f3:数据-50
    // 上面形成运算链的过程中，各个环节的处理函数并没有被调用
    // 只有在迭代器上调了 hasNext 和 next ，才真正触发上面的运算链条的执行
    /*
     * 触发执行
        while(iter4.hasNext){
            println(iter4.next())
         }
    */
    iter4.foreach(println) // 触发执行   def foreach[U](f: A => U) { while (hasNext) f(next()) }
  }
}
