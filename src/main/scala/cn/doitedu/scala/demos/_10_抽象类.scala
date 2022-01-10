package cn.doitedu.scala.demos

abstract class Animal(val id: Int) {
  // 具体成员
  var isAlive: Boolean = true

  // 抽象成员变量
  var category: String

  // 具体方法
  def move() {
    println("发生了位移")
  }

  // 抽象方法
  def buildHouse()
}

class Cat(id: Int) extends Animal(id) {
  override var category: String = _

  override def buildHouse(): Unit = {
    println("哆嗦嗦哆嗦嗦，寒风冻死我，明天就搭窝")
  }
}


class _10_抽象类 {

}
