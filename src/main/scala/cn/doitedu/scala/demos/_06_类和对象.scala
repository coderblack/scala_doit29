package cn.doitedu.scala.demos

// 类的定义，直接就是构造方法的定义
// 加了修饰符 val 的构造参数，自动会被编译成类的final的成员属性,而且,会自动生成该成员属性的“取值方法”,方法名就是 变量名
// 加了修饰符 val 的构造参数，自动会被编译成类的可修改的成员属性,而且,会自动生成该成员属性的“取值方法”和“设置新值的方法”
class Teacher(val id:Int,val name:String,var age:Int,course:String){
  def say():Unit = {
    println(this.name)
  }

  def setAge(age:Int):Unit = {
    this.age = age
  }

}


// TODO  定义一个 Computer类,要有属性: brand,cpuPrice,screenPrice,memPrice,totalPrice
//       要求构造函数中不要传 totalPrice
//       要求有一个方法： myPrice  功能：打印电脑自己的总价
class Computer(val brand:String,  // 成员变量
               val cpuPrice:Double,  // 成员变量
               val screenPrice:Double,  // 成员变量
               val memPrice:Double,  // 成员变量
               discount:Double){  // 局部参数
  // 在类体中定义的变量，也是成员变量
  var totalPrice:Double = (cpuPrice+screenPrice+memPrice)*discount

  // 类体中定义的函数，就是 “成员函数”（成员变量）
  val totalAmount = (computer:Computer)=>{ computer.totalPrice }

  /**
   * 辅助构造器
   */
  def this(brand:String,cpuPrice:Double,screenPrice:Double){
    // 辅助构造器的第一句话，只能是调用别的构造器（主构造器、其他辅助构造器）
    this(brand,cpuPrice,screenPrice,1200,1.0)

    println("")
  }

  /**
   * 辅助构造器
   */
  def this(brand:String,cpuPrice:Double){
    // 辅助构造器的第一句话，只能是调用别的构造器（主构造器、其他辅助构造器）
    this(brand,cpuPrice,1000)

    println("")
  }

  // 成员方法
  def myPrice():Unit = {
    println(this.totalPrice)
  }
}




object _06_类和对象 {
  def main(args: Array[String]): Unit = {

    val computer = new Computer("神舟", 1782, 1000, 1200, 0.95)
    computer.myPrice()

    val amount: Computer => Double = computer.totalAmount  // 这里只是把函数对象赋给另一个变量 amount来引用
    val r: Double = computer.totalAmount(computer)  // 这才是调用函数


    val t1 = new Teacher(1, "星哥", 48, "flink")
    println(t1.id)
    println(t1.name)
    // age有改值的方法
    val age = t1.age  // 取值方法，方法名就叫 age
    t1.age = 28  // 改值的方法,方法名叫 age_$eq , scala编译器看见 t1.age = 28，就会编译成  t1.age_$eq(28)

  }

}
