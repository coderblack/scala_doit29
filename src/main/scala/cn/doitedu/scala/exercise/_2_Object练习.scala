package cn.doitedu.scala.exercise


// TODO 定义一个object，里面放一个成员 base = 100
// TODO 然后，定义1个工具方法 ： 求两数之和并返回（<base,则返回base）
//           定义2个工具函数 ： 求两数之差并返回（<base,则返回base）  求3数之最大值并返回（<base,则返回base）
object Exercise{
  val base:Int = 100

  def add(a:Int,b:Int):Int = {
    if(a+b<base) base else a+b
  }

  val f1 = (a:Int,b:Int)=>{ if(a-b<base) base else a-b }

  val f2 = (a:Int,b:Int,c:Int)=>{
    var mx:Int = a
    if(b>mx) mx = b
    if(c>mx) mx = c

    if(mx<base) base else mx
  }

}

object Object练习 {
  def main(args: Array[String]): Unit = {
    println(Exercise.add(10, 20))
    println(Exercise.add(10, 200))
    println(Exercise.f1(250, 100))
    println(Exercise.f2(10, 1000, 800))
  }
}
