package cn.doitedu.scala.demos

object _27_传名调用CallByName {

  def main(args: Array[String]): Unit = {

    def prefix(e: Int): String = {
      println("prefix 方法被执行了")
      "prefix-" + e
    }

    //val res: String = prefix(10)

    val add = (x: Int, y: Int) => {
      println("add 函数被执行了")
      x + y
    }

    prefix(add(10, 20)) // 相当于传了一个30进去


    def prefix2(x:Int,y:Int,f:(Int,Int)=>Int): String ={
      println("做点别的.....")
      val sum = f(x, y)
      "prefix-"+sum
    }
    prefix2(10,20,(x,y)=>x+y)



    // 此处的x就是一个传名参数
    def prefix3(x: => Int): String ={
      println("prefix3被调用了....")
      "prefix-"+x
    }

    prefix3(10)

    val f = (x:Int)=>{
      println("函数f被调用了")
      x+10
    }
    // 此处传入的f(10) 不会被立即计算出来
    // 而是在prefix3的函数逻辑中，什么时候使用到这个值，才会去真正执行f(10)
    prefix3( f(10) )


  }
}
