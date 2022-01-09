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





object _06_类和对象 {
  def main(args: Array[String]): Unit = {

    val teacher1 = new Teacher(1, "星哥", 48, "flink")
    println(teacher1.id)
    println(teacher1.name)
    // age有改值的方法
    val age = teacher1.age  // 取值方法，方法名就叫 age
    teacher1.age = 28  // 改值的方法,方法名叫 age_$eq , scala编译器看见 age = 28，就会编译成  age_$eq(28)

  }

}
