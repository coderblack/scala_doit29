package cn.doitedu.scala.demos

import scala.util.Random

object _24_泛型 {

  def main(args: Array[String]): Unit = {


    val lst = List[Int](1, 2)

    class Util() {
      def max(a: Int, b: Int): Unit = if (a.compare(b) >= 0) a else b
    }
    new Util().max(5, 6)
    // new Util().max("5","6")   类型已经被写死，传入字符串就会不匹配


    /**
     * 泛型的基本语法
     *
     * @tparam T
     */
    // 类名[T]中的[T]就是这个类要接收的一个泛型参数的定义
    // 类上定义的泛型参数T，在整个类的作用域内都可以被使用
    class Util2[T]() {
      // a、b参数的类型并没有写死，而是用T代替
      // 而T是一个表示某类型的“泛型参数”
      def max(a: T, b: T): Unit = a
    }
    new Util2[Int].max(5, 6)
    new Util2[String].max("5", "6")

    class Util3() {
      // 在方法上声明“泛型参数 T”,那么这个T只能在该方法的作用域内使用
      def max[T](a: T, b: T): T = a
    }

    // 稍微复杂的例子
    class Util4 {
      def func[A, B](a: A, f: A => B): B = {
        f(a)
      }
    }
    val util4 = new Util4
    val res: Int = util4.func[String, Int]("555", s => s.toInt)


    /**
     * 泛型上界
     */
    class Desk {
      def compare(d: Desk): Int = new Random().nextInt(10)
    }
    class BlackDesk extends Desk
    class BlackCircleDesk extends BlackDesk

    class Bench

    class Util5[T <: Desk]() {
      def max(a: T, b: T): T = if (a.compare(b) >= 0) a else b

      def min(a: T, b: T): T = if (a.compare(b) <= 0) a else b
    }
    new Util5[Desk].max(new Desk(), new Desk())
    new Util5[BlackDesk].max(new BlackDesk(), new BlackDesk())
    // new Util5[Bench].max(new Bench(),new Bench())  会报错，因为Bench不是Desk的子类

    // T 必须是 BlackDesk 本身或它的超类
    class Util6[T >: BlackDesk]() {
      def max(a: T, b: T): Unit = println(a)
    }
    new Util6[Desk]()
    new Util6[BlackDesk]()
    // new Util6[BlackCircleDesk]()  // BlackCircleDesk 是下界的子类，比下界还小，不匹配


    /**
     * 泛型的视图界定 ： T <% B
     * 约束本质： 就是存在一个隐式转换，能将 T类型转成B类型
     */
    class Bird(val name: String) {
      def fly(): Unit = println(s"${name} 飞走了")
    }
    class ToyBird


    def bitBird[T <% Bird](b: T):Unit = b.fly()

    bitBird[Bird](new Bird("爱情鸟"))

    implicit def toy2Bird(toy:ToyBird) = new Bird("玩具鸟")
    bitBird[ToyBird](new ToyBird)


    /**
     * 泛型的上下文界定
     *
     */

    case class Tiger(age:Int,weight:Int)
    case class Leopard(age:Int,weight:Int)

    // 一切都写死的原型
    def bigger1(tiger1:Tiger,tiger2:Tiger,ord:Ordering[Tiger]): Tiger ={
      if (ord.compare(tiger1,tiger2) > 0)  tiger1 else tiger2
    }

    // 将类型，参数化 ==》 泛型
    def bigger2[T](tiger1:T,tiger2:T,ord:Ordering[T]): T ={
      if (ord.compare(tiger1,tiger2) > 0)  tiger1 else tiger2
    }

    // 比较器能不能别让使用者手动传（隐式传更优雅）
    def bigger3[T](tiger1:T,tiger2:T)(implicit ord:Ordering[T]): T ={
      if ( ord.compare(tiger1,tiger2) > 0)  tiger1 else tiger2
    }
    // 表示 T 应该有一个对应的  隐式Ordering[T]对象
    def bigger4[T:Ordering](tiger1:T,tiger2:T): T ={
      // implicitly[Ordering[T]] 就是去上下文中抓取一个比较器[T]对象
      if (implicitly[Ordering[T]].compare(tiger1,tiger2) > 0)  tiger1 else tiger2
    }

    val t1 = Tiger(10, 400)
    val t2 = Tiger(8, 500)

    implicit val ord = new Ordering[Tiger] {
      override def compare(x: Tiger, y: Tiger): Int = x.weight.compare(y.weight)
    }
    println(bigger4[Tiger](t1, t2))

    val l1 = Leopard(2, 100)
    val l2 = Leopard(3, 150)

    implicit val ord2 = Ordering.by[Leopard,Int](l=>l.age)
    bigger4[Leopard](l1, l2)


  }
}
