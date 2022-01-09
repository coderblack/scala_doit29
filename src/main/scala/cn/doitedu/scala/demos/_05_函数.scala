package cn.doitedu.scala.demos

import cn.doit.edu.java.DoitStu

object _05_函数 {

  // 函数，就是一段逻辑的封装，就这一点来说，跟方法一致
  // 本函数没有函数名，称之为： 匿名函数
  (a: Int, b: Int) => {a+b}

  // 为函数命名为 multiply
  val multiply = (a:Int,b:Int)=>{a*b}

  def main(args: Array[String]): Unit = {
    val res = multiply(2, 3)
    println(res)

    val diff = (a:Int,b:Int)=>{ a - b }
    println(diff(10, 3))


    /**
     * 函数对象（变量）的类型表达
     * div:Function2[Float,Int,Float] 是java底层的正统表达
     * div:(Float,Int)=>Float  是scala提供的语法糖
     */
    // val div:Function2[Float,Int,Float]= (a:Float,b:Int)=>{a/b}
    val div: (Float,Int)=>Float  = (a:Float,b:Int)=>{a/b}

    // f1:Function2[String,Int,Int]
    // f1:(String,Int)=>Int
    val f1 = (s:String,i:Int)=>{
      s.toInt + i
    }


    // TODO 练习，自己为f2这个函数对象 写上  类型名(正统的和语法糖的)
    // f2:Function3[DoitStu,Int,String,Unit]
    // f2:(DoitStu,Int,String)=>Unit
    val f2:(DoitStu,Int,String)=>Unit = (p:DoitStu, incr:Int, nickname:String)=>{
      println(nickname + "年龄现在是： " + (p.getAge+incr))
    }





    // 定义一个函数，输入3个整数，返回最大值
    // scala的所谓函数，本质上就是一个接口的匿名实现类的对象
    val max= (a:Int,b:Int,c:Int)=>{
      var mx = a
      if(b>mx) mx = b
      if(c>mx) mx = c
      mx
    }

    val mx = max(3, 9, 2)
    println(mx)
  }

  def say(): Unit ={
    /**
     * mutiply函数之所以能在 say方法中调用，是因为mutiply这个函数（对象）是定义在成员变量上
     */
    multiply(10,20)
    multiply.apply(10,20)

    /**
     * max函数在这里不能调用，因为max是定义在main方法中的一个局部变量
     */
    // max(10,3,9)
  }


}
