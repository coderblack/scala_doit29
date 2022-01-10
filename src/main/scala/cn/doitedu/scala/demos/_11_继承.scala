package cn.doitedu.scala.demos

class Father(val id: Int = 10, var name: String, val gender: String, prefix: String) {
  def myName(): Unit = {
    println(this.name + " " + prefix)
  }
}

class Son extends Father(1, "马云", "male", "富豪")

class Daughter(id: Int, name: String, gender: String, prefix: String) extends Father(id, name, gender, prefix)

// 子类中将构造参数声明为val成员（且该变量名在父类中已经声明为了成员），则需要加override
// 子类中不允许override父类中的 var 成员
class SonInLaw(override val id: Int, name: String, gender: String) extends Father(id, name, gender, "干儿子")

// 子类中成员变量可以比父类的多
class DaughterInLaw(override val id: Int, name: String, gender: String, val prefix: String, val inheritRatio: Double) extends Father(id, name, gender, prefix)

class sonInSecret(n: String, g: String) extends Father(name = n, gender = g, prefix = "") {

  // 覆盖父类中的成员方法
  override def myName(): Unit = {
    println("please  ask my father")
  }

  // 子类自己的成员方法
  def fightForMoney(): Unit ={
    println("财产想不给我，那是不可能的")
  }
}


object _11_继承 {

  def main(args: Array[String]): Unit = {

    /**
     * val child = new Son
     * println(child.id)
     * println(child.name)
     * println(child.gender)
     * child.myName()
     * */


    /**
     * val child2 = new Daughter(1, "章子怡", "female", "国际章")
     * println(child2.id)
     * println(child2.name)
     * println(child2.gender)
     * child2.myName()
     */

    val son2 = new SonInLaw(2, "思聪", "male")
    son2.myName()


    def add(a: Int = 19, b: Int, c: Int): Int = {
      a + b + c
    }

    add(b = 10, c = 20)

  }

}
