package cn.doitedu.scala.exercise

import java.util
import java.util.{Collections, Comparator}
import scala.util.Sorting


/**
 *
 * TODO 定义一个样例类，封装订单信息 : 订单id，订单总金额，订单的支付方式，订单所属的用户 ，订单商品所属品类
 * 定义一个object类，封装一个工具方法：接收参数： 2个订单，逻辑： 订单1金额>订单2金额，则返回1 ，如果金额相同就返回0 ，否则返回-1
 *
 * 在测试程序中，创建出 5个各式各样的订单对象，装入一个java的ArrayList中
 *
 * 然后想办法利用上面的成果:
 * 需求1： 对这5个订单按金额大小升序排序
 * 需求2： 对这5个订单按金额大小降序排序
 * 需求3： 统计每一种品类下的订单总额
 * 需求4： 统计每一个用户的订单总额
 * 需求5： 找出每个用户金额最大的那个订单
 * 需求6： 找出每一种品类中金额最大的订单
 * 需求7： 找出订单金额最大的两个订单
 * 需求8： 找出订单金额最小的两个订单
 * 需求9： 统计每一种品类的订单的平均金额
 * 需求10：求每种品种中金额最大的2个订单，并且结果形式如下：
 *    Map(
 *        食品->Order(1,3,.8.8..)
 *        食品->Order(3,2,.7.8..)
 *        饮料->Order(4,1,.9.8..)
 *        饮料->Order(5,2,.8.8..)
 *      )
 *
 */
case class Order(val id: Int, val amount: Double, val payType: Int, val uid: Int, val category: String)

object OrderCompare {
  def compare(o1: Order, o2: Order): Int = {
    if (o1.amount > o2.amount) {
      1
    } else if (o1.amount == o2.amount) {
      0
    } else {
      -1
    }
  }
}

object Day01综合练习 {
  def main(args: Array[String]): Unit = {
    // 创建5个订单
    val od1 = Order(1, 10.5, 1, 1, "食品")
    val od2 = Order(2, 12.5, 2, 1, "电子")
    val od3 = Order(3, 20.5, 3, 2, "电子")
    val od4 = Order(4, 30.0, 2, 2, "服装")
    val od5 = Order(5, 15.5, 1, 3, "食品")

    // 将5个订单对象装入一个ArrayList
    val orders = new util.ArrayList[Order]()
    orders.add(od1)
    orders.add(od2)
    orders.add(od3)
    orders.add(od4)
    orders.add(od5)

    // 按金额排序
    Collections.sort(orders, new Comparator[Order] {
      override def compare(o1: Order, o2: Order): Int = OrderCompare.compare(o1, o2)
    })

    // 打印排序的结果
    println(orders)
  }

}


object Day01综合练习解答 {
  def main(args: Array[String]): Unit = {
    /*val orders = new Array[Order](5)
    orders(0) = Order(1,8.8,1,2,"食品")*/

    val orders = Array(
      Order(1, 8.8, 1, 2, "食品"),
      Order(2, 4.8, 2, 2, "食品"),
      Order(3, 6.8, 2, 3, "饮料"),
      Order(4, 5.8, 1, 3, "食品"),
      Order(5, 8.8, 1, 2, "饮料")
    )

    // 需求1：
    val ordering = new Ordering[Order] {
      override def compare(x: Order, y: Order): Int = x.amount.compare(y.amount)
    }
    Sorting.quickSort(orders)(ordering)
    println(orders.mkString(","))

    // 需求2：
    Sorting.quickSort(orders)(ordering.reverse)

    println("------------需求3：------------------")
    // 需求3：
    val groupedByCategory: Map[String, Array[Order]] = orders.groupBy(order => order.category)
    val res: Map[String, Double] = groupedByCategory.map(tp=>{
      // 商品类别
      val category: String = tp._1

      val orderGroup: Array[Order] = tp._2
      // 把订单组 映射成 金额组
      val amtGroup: Array[Double] = orderGroup.map(order => order.amount)

      // 对金额组求和
      val sum: Double = amtGroup.sum

      // 返回结果：（品类，订单总额）
      (category,sum)
    })
    println(res) //  Map(饮料 -> 15.600000000000001, 食品 -> 19.400000000000002)

    // TODO 需求4：

    println("------------需求5：------------------")
    // 需求5：
    // 先将所有订单按照uid分组
    val groupedByUid: Map[Int, Array[Order]] = orders.groupBy(order => order.uid)
    // 对每一个订单组进行排序，并取排序后的第1个元素
    val res5 = groupedByUid.map(kv=>{
      val uid: Int = kv._1  // 一个人
      val ods: Array[Order] = kv._2  // 这个人的一组订单
      /*Sorting.quickSort(ods)(new Ordering[Order] {
        override def compare(x: Order, y: Order): Int = x.amount.compare(y.amount)
      })*/
      Sorting.quickSort(ods)((x: Order, y: Order) => y.amount.compare(x.amount))

      (uid,ods(0))
    })
    println(res5)



  }
}
