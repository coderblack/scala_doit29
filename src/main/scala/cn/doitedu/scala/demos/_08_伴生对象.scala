package cn.doitedu.scala.demos


class Car(val brand: String, val price: Double) {
  // 普通成员方法
  def sing(): Unit = {
    println("啦啦啦，啦啦啦，我是烧电的小行家")
  }
}

// Car类的伴生对象
object Car {
  // 静态方法
  def fire(): Unit = {
    println("嗡~~~~~~~~~~~~~~~~")
  }

  // apply方法，与类的对象构造简化有关
  def apply(brand: String, price: Double): Car = {
    print("apply被调用了");
    new Car(brand, price)
  }

  // 伴生对象中的unapply方法，与scala中一个重要的功能特性：模式匹配  有关
  def unapply(car: Car): Option[(String, Double)] = Some((car.brand,car.price))

}


/**
 * 编译后的结构：
 * class Car${
 *    Car$ MODULE$
 *    public void fire(){ println("嗡~~~~~~~~~~~~~~~") }
 * }
 *
 * class Car{
 *   private String brand;
 *   private Double price;
 *   public void sing(){ println("啦啦啦，啦啦啦，我是烧电的小行家") }
 *
 *   public static fire(){ Car$.MODULE$.fire() }
 * }
 *
 */
object _08_伴生对象 {
  def main(args: Array[String]): Unit = {
    val car1 = new Car("比亚迪·唐", 234990)
    car1.sing() // 普通成员方法，得在对象上调

    Car.fire() // object中的方法，直接在类名上调

    // 构造一个Car对象
    // 这里又是一个 语法糖, Car("比亚迪·宋", 350000)本质上就是调用的Car类的伴生对象上的apply方法
    val car2 = Car("比亚迪·宋", 350000)

  }

}
