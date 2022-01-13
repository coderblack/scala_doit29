package cn.doitedu.scala.demos

object _21_高阶函数_ {

  def main(args: Array[String]): Unit = {

    def add(x:Int,y:Int):Int={
      x+y
    }

    def add2(x:Int,op:(Int,Int)=>Int) = {
      op(x,10)
    }

    val res1 = add2(5, (x, y) => x + y)
    val res2 = add2(5, (x, y) => x * y)
    println(res1)
    println(res2)

    /**
     * 模仿add2，写一个方法
     * 要求接收一个整数数组和一个函数，最终返回一个整数
     *    调用1：调它，实现 得到数组的总和
     *    调用2：调它，实现 得到数组的最大值
     *    调用3：调它，实现 得到数组的元素平方和
     *
     */






  }
}
