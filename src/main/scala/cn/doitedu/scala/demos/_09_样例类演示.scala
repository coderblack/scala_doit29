package cn.doitedu.scala.demos

import java.io.{FileOutputStream, ObjectOutputStream}


class Order1(val id:Int,val uid:Int,val payType:Int,var amount:Double)

case class Order2(val id:Int,val uid:Int,val payType:Int,var amount:Double)

object _09_样例类演示 {
  def main(args: Array[String]): Unit = {

    // 构造一个普通类Order1的对象
    val od1 = new Order1(1, 2, 3, 200.8)

    // 构造一个case class的对象
    val od2 = Order2(1, 2, 3, 250.8)
    /**
     * 从这里可以看出，加了case之后，编译器会自动为类生成伴生对象类，并且在伴生对象类中自动生成了 apply方法 、unapply方法（可以用于模式匹配）
     */

    val objOut = new ObjectOutputStream(new FileOutputStream("d:/od.obj"))
    //objOut.writeObject(od1)   // 这里会报错
    objOut.writeObject(od2)  // 这里会成功
    /**
     * 从这里可以看出，加了case之后，编译器会自动为类实现Serializable接口
     */

    println(od1)    // cn.doitedu.scala.demos.Order1@45c8e616
    println(od2)    // Order2(1,2,3,200.8)
    /**
     * 从这里可以看出，加了case之后，编译器会自动为类重写toString方法
     */

    val od11 = new Order1(1, 2, 3, 200.8)
    val od22 = Order2(1, 2, 3, 250.8)
    println(od1 == od11)  // false
    println(od2 == od22)  // true
    /**
     * 从这里可以看出，加了case之后，编译器会自动重写 equals方法，而且逻辑是：同一个对象肯定返回true，不同对象但是成员属性值都相同，也返回true；
     */

  }
}
