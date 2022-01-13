package cn.doitedu.scala.demos

object _21_高阶函数_ {

  def main(args: Array[String]): Unit = {

    def add(x: Int, y: Int): Int = {
      x + y
    }


    /**
     * 接收一个函数作为参数
     */

    def add2(x: Int, op: (Int, Int) => Int) = {
      op(x, 10)
    }

    val res1 = add2(5, (x, y) => x + y)
    val res2 = add2(5, (x, y) => x * y)
    println(res1)
    println(res2)

    /**
     * 模仿add2，写一个方法
     * 要求接收一个整数List和一个函数，最终返回一个整数
     * 调用1：调它，实现 得到List的总和
     * 调用2：调它，实现 得到List的最大值
     * 调用3：调它，实现 得到List的元素平方和
     */
    def listOp(lst: List[Int], op: List[Int] => Int): Int = {
      op(lst)
    }

    // 调用1：调它，实现 得到List的总和
    val r1 = listOp(List(1, 2, 3), (lst: List[Int]) => {
      lst.sum
    })
    println(r1)

    // 调用2：调它，实现 得到List的最大值
    val r2 = listOp(List(1, 2, 3), (lst: List[Int]) => lst.max)
    println(r2)

    // 调用3：调它，实现 得到List的元素平方和
    val r3 = listOp(List(1, 2, 3), (lst: List[Int]) => {
      lst.map(Math.pow(_, 2)).sum.toInt
    })
    println(r3)


    /**
     * 返回结果：是函数
     * @param x
     * @return
     */
    def add3(x: Int): Int => Int = {
      (y: Int) => x + y
    }

    val f: Int => Int = add3(10) // 调用add3,得到的是一个函数： i=>10+i
    val res = f(20)  // 调用f函数，得到了最终结果值： 30


    /**
     * 返回函数作为结果的“函数”
     */
    // func 首先是一个函数，它接收的参数是：一个整数； 它返回的结果是：一个函数
    // 返回的结果函数是：接收一个整数，返回一个整数
    val func: Int => Int=>Int = (x:Int)=> {
      (y:Int)=>x+y
    }

    /**
     * 接收函数作为参数的“函数”
     */
    val func1: (Int=>Int,Double)=>Int = (op:Int=>Int,d:Double)=> {
      (op(3)+d).toInt
    }


  }
}
