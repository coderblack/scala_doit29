package cn.doitedu.scala.demos

import scala.language.implicitConversions

object _23_隐式转换 {
  def main(args: Array[String]): Unit = {

    /**
     * 隐式参数 和 隐式值：就是在参数列表前 添加一个implicit修饰，则意味着这些参数可以被隐式传入
     * 什么时候才会帮忙隐式传入参数呢？  编译器在上下文中能找到对应参数类型的 隐式变量（隐式值）
     *
     * @param x
     * @param y
     * @return
     */
    // x隐式参数，y隐式参数
    def add(implicit x: Int, y: String) = {
      println("我被调用了")
      x + y.toInt
    } // implicit修饰的参数，表示：可以被隐式传入的参数

    println(add(10, "20")) // 可以显示传入参数

    implicit val a: Int = 20 // 隐式值
    implicit val b: String = "20" // 隐式值
    val c: Int = 30  // 这里不能加implicit，否则下面的代码都会报错,因为在上下文中出现了两个Int类型的隐式值
    println(add) // 没有显示传入参数，而是被隐式传入了（编译器）


    def add2(y: String)(implicit x:Int) = x+y.toInt
    println(add2("30"))  // 50  参数x被隐式地传入了a值


    def add3(implicit p1:Int,p2:Int) = p1+p2
    println(add3)



    /**
     * 隐式方法 ：
     *   通过一个用implicit修饰的方法：接收一个A对象，返回一个B对象
     *
     * 那么，我们就可以直接在A对象上调B对象的方法
     */
    val str = "风口上的猪"
    class AnyThingCanFly(val str:String){
      def fly() = println(s"$str 飞起来了.....")
    }
    implicit def str2Fly(s:String ) = new AnyThingCanFly(s)

    str.fly()   // str2Fly(str).fly()

    /**
     * 模仿上面的语法： 让整数可以直接调 concat 方法
     */
    val ele:Int = 5
    implicit def int2Str(e:Int) = s"${e}nb "
    println(ele.concat("haha"))

    /**
     * 隐式类 : 类名前加implicit修饰，它的主构造器能接收一个A类型的值，返回一个B类型
     *
     * 那么，在A类型的对象上，就可以直接调B类型的方法
     *
     */
    class Ant

    implicit class Snake(ant:Ant){
      def eatElephant(): Unit ={
        println("谁说我吃不了大象？")
      }
    }
    val ant = new Ant()
    ant.eatElephant()  // 编译器会把ant传入Snake的构造器，得到一个Snake对象，然后调eatElephant方法

  }
}
