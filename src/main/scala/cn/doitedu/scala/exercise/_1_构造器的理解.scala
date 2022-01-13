package cn.doitedu.scala.exercise

class  DoitSchool(val xiaoZhang:String, val terms:Int){
  val address:String = "上海·北京"
  var studentCnt:Int = _

  // 构造对象时，会打印语句
  val  f1  = println("欢迎来到多易教育......")

  // 构造对象时，不会打印语句
  val  f2: () => Int = ()=>{println("欢迎来到多易教育*****");10}

  // 这样不打印
  val f3  = f2

  // 打印
  val f4: Int = f2()
  println(f4)

  // 构造对象时，会打印
  f2()



  // 构造时，会打印
  println("欢迎来到上海多易教育")
}


object 构造器的理解 {
  def main(args: Array[String]): Unit = {

    val school = new DoitSchool("娜姐", 5)




  }

}
