object 逆变协变 {
  def main(args: Array[String]): Unit = {

    // 花
    class Flower(val color: String) {
      def cut() {
        println("修剪 ....")
      }
    }
    // 白色花
    class WhiteFlower(color: String) extends Flower(color) {
      def white() {
        println("白色闪亮.......")
      }
    }


    /*
    // 协变演示案例
    // 生产者抽象类
    abstract class Producer[+T] {
      def product(): T
    }

    // 花生产者
    val producer1: Producer[Flower] = new Producer[Flower] {
      override def product(): Flower = new Flower("未知")
    }

    // 白花生产者
    val producer2: Producer[WhiteFlower] = new Producer[WhiteFlower] {
      override def product(): WhiteFlower = new WhiteFlower("白色")
    }

    // 花朵包装器，需要传入一个“花生产者”
    def enclose(producer: Producer[Flower]): Unit = {
      println(s"美美地包装好这朵颜色为：${producer.product().color}花了")
    }

    // 给包装起来传入一个“花生产者”，编译通过
    enclose(producer1)
    // 给包装器传入一个“白花生产者”,编译失败，因为 Producer[Flower] 与 Producer[WhiteFlower] 完全没有任何关系
    enclose(producer2)


    // 逆变  演示案例
    // 抽象比较器
    abstract class Comparator[-T] {
      def compare(t1: T, t2: T): Int
    }
    // 花卉比较器
    val cmp1 = new Comparator[Flower] {
      override def compare(t1: Flower, t2: Flower): Int = t1.color.compareTo(t2.color)
    }

    // 白花比较器
    val cmp2 = new Comparator[WhiteFlower] {
      override def compare(t1: WhiteFlower, t2: WhiteFlower): Int = t1.color.compareTo(t2.color)
    }

    class Selector[T] {
      def getMax(f1: T, f2: T, comparator: Comparator[T]): T = {
        if (comparator.compare(f1, f2) > 0) f1 else f2
      }
    }

    new Selector[Flower].getMax(new Flower("未知"), new Flower("随便"), cmp1)
    new Selector[WhiteFlower].getMax(new WhiteFlower("未知"), new WhiteFlower("随便"), cmp1)*/



    // 礼物
    class Gift {
      def ring(): Unit = println("ring")
    }
    // 精品礼物
    class FinedGift extends Gift {
      def speak(): Unit = println("hello little boy")
    }
    // 礼品加工店
    abstract class GiftStore[-T, +U] {
      def sale(t: T): U
    }
    // 白花礼品加工店
    val store1: GiftStore[WhiteFlower, Gift] = new GiftStore[WhiteFlower, Gift] {
      override def sale(t: WhiteFlower): Gift = {
        t.white()
        new Gift
      }
    }
    // 花卉精品加工店
    val store2: GiftStore[Flower, FinedGift] = new GiftStore[Flower, FinedGift] {
      override def sale(t: Flower): FinedGift = {
        t.cut()
        new FinedGift
      }
    }

    // 能接受白花礼品加工店
    def buyGift(giftStore: GiftStore[WhiteFlower, Gift]): Unit = {
      val gift = giftStore.sale(new WhiteFlower("粉白"))
      gift.ring()
    }

    buyGift(store1)
    // 理应也要能接受： 花卉精品加工店
    buyGift(store2)

  }
}
