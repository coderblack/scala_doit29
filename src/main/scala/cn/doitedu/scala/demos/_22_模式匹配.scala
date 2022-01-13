package cn.doitedu.scala.demos

import scala.runtime.Nothing$

object _22_模式匹配 {
  def main(args: Array[String]): Unit = {

    /**
     * 1. 值匹配
     */
    val x = 1
    x match {
      case 1 => println("你是第1名")
      case 2 => println("你是第2名")
      case 3 => println("你是第3名")
      case _ => println("你不入流")
    }

    val name = "张三"
    name match {
      case "张三" => println("我认识你")
      case "李四" => println("我上辈子认识你")
      case _ => println("你未生时你是谁，生你之时谁是你")
    }


    /**
     * 2：类型匹配
     * 注意：匹配类型时，不会区分类型所带的泛型！！！
     */
    val lst1: Any = List(3, 5, 6, 8)
    val lst2: Any = List("a", "b")
    val mp: Any = Map("a" -> 1)
    mp match {
      case e: Map[Int, String] => println("这是一个Map[Int,String]：  " + e) // 并不会去匹配到泛型
      case e: String => println("这是一个String：  " + e)
      case e: List[String] => println("这是一个List[String]：  " + e) // 并不会去匹配到泛型
      case _ => println("其他")
    }



    /**
     * 3. 解构匹配
     * 注意：能用解构匹配的类型，必须是实现了apply和unapply方法的类型
     */
    val lst = List(3)
    lst match {
      case List(e1, _) => println(s"这是一个List,而且正好2个元素，第一个元素：$e1")
      case List(e1, _*) => println(s"这是一个List,而且至少有1个元素：$e1")
      case List(head, tail) => println(s"这是一个List，而且正好2个元素，分别是：${head} 和 ${tail}")
      case List(e1, e2, e3, _) if(e1>5) => println(s"这是一个list,有4个元素,而且第一个元素>5，分别是 ${e1}, ${e2} ,${e3}")
      case head :: Nil => println(s"这是一个List，而且只有一个元素： $head")
      case _ => println("其他")
    }

    // 自动实现了apply 和 unapply
    case class House(id: Int, name: String, price: Double)
    val house = House(1, "上计信息楼", 300000)
    house match {
      case h: House => println("这是一栋House： " + h)
      case House(id: Int, name: String, _) => println(s"这是一栋house，而且id为$id,name为 $name")
      case _ => println("其他")
    }

    // 为Bicycle类型，手动实现了 apply 和 unapply
    class Bicycle(val id: Int, val name: String, val price: Double)
    object Bicycle{
      def apply(id: Int, name: String, price: Double): Bicycle = new Bicycle(id, name, price)
      def unapply(obj: Bicycle): Option[(Int, String, Double)] = Some((obj.id,obj.name,obj.price))
    }

    val bicycle = new Bicycle(1, "捷安特", 88.8)
    bicycle match {
      case Bicycle(_,_,price) if(price<80) => println(s"这是一部 bicycle，而且它的价格是80以内： $price")  // 增加了一个if守卫
      case Bicycle(_,_,price) => println(s"这是一部 bicycle，而且它的价格是80以外： $price")
      case _ =>println(" 其他东西 ")
    }

    /**
     * 4. 模式匹配的一些其他用法
     */
    // 用模式匹配来做变量定义
    val Array(a,b)=Array(3,4)
    println(a)
    println(b)

    // House实现了apply和unapply，所以也可以这么写
    // 相当于定义了3个变量：p1  p2  p3
    val House(p1,p2:String,p3) = House(1,"上计信息",88.8)

    // 元组也实现了apply和unapply，所以也可以这么写
    val (z1,z2) = (10,20)


    /**
     * 5. 模式匹配在for循环中用作推导式
     */
    val houseList = List(House(1,"a",88),House(2,"b",100),House(3,"c",188))
    for(House(_,_,price) <- houseList){
      println(price)
    }

    val mp2 = Map("a"->33,"b"->44,"c"->55)
    for(tp <-mp2) {  // 本质就是整个值匹配
      println(tp._2)
    }

    for((k,v)<- mp2){  // 本质就是一个解构匹配
      println(v)
    }
    for((_,v)<-mp2){
      println(v)
    }

    for(i<- 1 to 100){ // 本质就是整个值匹配

    }


    /**
     * 6. 模式匹配用作偏函数（部分函数）
     */
    val intList = List(1,2,3,4,5,6)
    val res1 = intList.filter(e=>e%2==0).map(e=>e*10)  // 收集到原来的list中的所有偶数*10

    val pf = new PartialFunction[Int,Int] {
      override def isDefinedAt(x: Int): Boolean = x % 2 == 0  // 过滤条件
      override def apply(x: Int): Int = x * 10   // 变换逻辑
    }
    val res2 = intList.collect(pf)  // collect 调偏函数的时候，就是先调过滤条件判断这个值是要还是不要；然后调apply做运算

    /**
     * 偏函数的语法糖，直接用{case .. => ..}来表示偏函数
     */
    val res3 = intList.collect({
      // if守卫，就相当于正统写法中的 idDefinedAt
      // case的返回值相当于 apply
      case x if(x%2==0)=> x*10
    })
    println(res3)

    /**
     * 也可以给偏函数定义一个变量名来使用
     */
    val pf2: PartialFunction[Int,Int] = {
      case x if(x%2==0)=> x*10
    }
    intList.collect(pf2)

  }
}
