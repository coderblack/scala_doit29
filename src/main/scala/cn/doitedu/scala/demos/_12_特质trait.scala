package cn.doitedu.scala.demos

trait CanBuildHouse{
  def buildHouse()
}


trait CanFly{
  def fly()
}


trait CanJump{
  def jump()
  def bigJump(): Unit ={
    println("纵深一跃，龙跃九天")
  }
}

trait CanBirthDragon{
  def birthDragon()
}




class Dog(val id:Int,val name:String) extends CanBuildHouse with CanJump {
  override def buildHouse(): Unit = println("搭个狗窝")

  override def jump(): Unit = println("见到骨头就开跳")
}

class Phoenix(val id:Int,val name:String) extends Serializable with CanBuildHouse with CanJump  with CanFly {
  override def buildHouse(): Unit = println("我建巢是是有知识产权的，你看不了")

  override def jump(): Unit = println("优雅地一抬腿")

  override def fly(): Unit = println("与龙共舞")
}


object _12_特质trait {
  def main(args: Array[String]): Unit = {
    val phoenix = new Phoenix(1, "基因改造的凤凰") with CanBirthDragon {
      override def birthDragon(): Unit = println("哇哇哇，我怎么拉出一条虫出来了")
    }

    phoenix.buildHouse()
    phoenix.fly()
    phoenix.jump()
    phoenix.bigJump()
    phoenix.birthDragon()


  }
}
