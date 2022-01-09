package cn.doitedu.scala.demos

/**
 * 普通类
 * 成员变量和成员方法，必须在对象上引用
 */
class Cup1(val brand:String,val price:Double){
  val color:String = "yellow"

  def howMuch()={
    println(this.price)
  }

}

/**
 * object类：成员变量和成员方法，都可以在类名后直接引用（相当于java中的static）
 * object类的底层，是会生成两个类：
 *    1、  Cup2 类
 *    2、  Cup2$ 类
 *    Cup2类中，是根据object中定义的成员变量和成员方法，自动生成了一堆的static静态方法，因而可以在Cup2类上直接调用这些静态方法
 *    Cup2$类，则是一个装着object中定义的成员变量和成员方法的普通类，不过这个类中持有了一个Cup2$类自身的单例对象$MODULE
 *    Cup2类中的那些静态化的方法，就是调用的 静态单例对象$MODULE 的各种成员方法
 */
object Cup2{
  val brand:String = "多易日用"   // 定义成员变量，val修饰,就必须赋值
  val price:Double = 99.9   // 定义成员变量，val修饰,就必须赋值
  var color:String = _   // 定义成员变量， var修饰，可以用占位符赋值, 其实就是赋值了该类型的默认值： null
  var width:Int = _   // 定义成员变量， var修饰，可以用占位符赋值, 其实就是赋值了该类型的默认值： 0

  def myPrice(): Unit ={
    val sum = price + 100
    println(sum)
  }
}


object _07_Object类_对象 {
  def main(args: Array[String]): Unit = {

    // 构造一个普通类的对象
    val cup1 = new Cup1("特斯拉", 8.8)
    println(cup1.brand)
    cup1.howMuch()

    /**
     * object类  没有构造器，所以也不用去 new
     */
    // object上的成员变量，可以直接在类名后面引用
    println(Cup2.price)
    println(Cup2.color)
    println(Cup2.width)
    Cup2.color = "红色"
    Cup2.width = 7

    // object上的成员方法，可以直接在类名后面调用
    Cup2.myPrice()
  }
}
