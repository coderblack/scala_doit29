package cn.doitedu.scala.demos


class Cup1(val brand:String,val price:Double){
  def howMuch()={
    println(this.price)
  }
}

/**
 * 和普通类的最大区别： object类中定义的成员、方法，都是相当于java中的static的
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
