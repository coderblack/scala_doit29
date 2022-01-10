package cn.doitedu.scala.demos

object _15_数组 {
  def main(args: Array[String]): Unit = {

    // 利用Array伴生对象的apply方法构造一个数组
    val arr1 = Array(10,20,30,50)

    // 创建空数组
    val arr2: Array[Int] = Array.empty[Int]

    // 从数组取值
    println(arr1(2))

    // 修改数组的元素值
    arr1(0) = 100
    println(arr1(0))

    // 修改数组的元素值
    arr1.update(0,150)
    println(arr1(0))



    println("--------------------------------------")
    // 遍历
    for(i <- 0 until arr1.length){
      println(arr1(i))
    }

    // 遍历
    arr1.foreach(x=>println(x))


    println("-----------map映射----映射------------------")
    val res1: Array[Int] = arr1.map( (x:Int)=>10 * x  )
    println(res1.mkString("[" ,",","]"))

    val res2 = arr1.map((x: Int) => {x + "_a"})
    println(res2.mkString(","))

    /**
     * 函数的简化写法
     */
    // arr1.map( (x:Int)=>x/2 )
    // arr1.map( (x)=>x/2 ) // 如果参数的类型可以由编译器推断成功，则参数的类型不用声明
    // arr1.map( x=>x/2 )  // 如果参数只有一个，则可以去掉括号
    arr1.map( _/2 )   // 如果参数在函数体中只用一次，则可以直接用 _  代替，并且在这种情况下如果参数还只有1个，那么连参数的声明都可以省略


    println("-----------flatten--压平--------------------")
    val arr3 = Array(Array(1, 2), Array(3, 5), Array(4, 6, 7))
    val res5 = arr3.flatten
    println(res5.mkString("[",",","]"))



    println("-----------flatMap映射--映射且压平--------------------")
    val res3 = arr3.map(     arr=>arr.map( _ * 10)    )  // 元素映射
    val res4 = arr3.flatMap( arr=>arr.map( _ * 10)    )  // 元素映射及压平

    println(res3.mkString("[",",","]"))
    println("----------------")
    println(res4.mkString("[",",","]"))


    println("-----------group--------------------")
    val arr4 = Array("hello", "hello", "scala", "hello", "java", "hello", "java","jack","jim")
    //arr4.groupBy(s=> if(s.startsWith("j")) 1 else 2)    // {1->[hello,hello,scala,hello,hello], 2->[java,java,jack,jim]}
    val res6: Map[String, Array[String]] = arr4.groupBy(s => s)
    /* {
     *  hello,[hello,hello,hello,hello]
    *   scala,[scala]
    *   java,[java,java]
    * }
    */
    println(res6)

    val res7: Map[String, Int] = res6.map(tp => (tp._1, tp._2.length))
    println(res7)



  }
}
