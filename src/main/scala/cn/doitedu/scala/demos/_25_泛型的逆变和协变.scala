package cn.doitedu.scala.demos

object _25_泛型的逆变和协变 {

  def main(args: Array[String]): Unit = {


    /**
     * 协变的语法示例
     * @param t
     * @tparam T
     */
    class Box[+T](t:T)
    class Pencil
    class YzPencil extends Pencil

    val bi :Pencil = new YzPencil
    //     Pencil    是     YzPencil  的父类
    // Box[Pencil] 就是 Box[YzPencil] 的父类
    val box2: Box[Pencil] = new Box[YzPencil](new YzPencil)




    /**
     * 逆变的语法示例
     * @param t
     * @tparam T
     */
    class Room[-T](t:T)
    class Tv
    class AiTv extends Tv

    //       Tv  是       AiTv  的父类
    // Room[Tv]  是 Room[AiTv]  的子类
    val r1: Room[AiTv] = new Room[Tv](new Tv)

  }

}
