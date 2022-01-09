package cn.doitedu.scala.exercise

import java.util
import java.util.{Collections, Comparator}


/**
 *
 * TODO 定义一个样例类，封装订单信息 : 订单id，订单总金额，订单的支付方式，订单所属的用户 ，订单商品所属品类
 * 定义一个object类，封装一个工具方法：接收参数： 2个订单，逻辑： 订单1金额>订单2金额，则返回1 ，如果金额相同就返回0 ，否则返回-1
 *
 * 在测试程序中，创建出 5个各式各样的订单对象，装入一个java的ArrayList中
 *
 * 然后想办法利用上面的成果:
 *   需求1： 对这5个订单按金额大小升序排序
 *   需求2： 对这5个订单按金额大小降序排序
 *   需求3： 统计每一种品类下的订单总额
 *   需求4： 统计每一个用户的订单总额
 *   需求5： 找出每个用户金额最大的那个订单
 *   需求6： 找出每一种品类中金额最大的订单
 *   需求7： 找出订单金额最大的两个订单
 *   需求8： 找出订单金额最小的两个订单
 *   需求9： 统计每一种品类的订单的平均金额
 */
case class Order(val id:Int,val amount:Double,val payType:Int,val uid:Int,val category:String)

object OrderCompare{
  def compare(o1:Order,o2:Order):Int = {
    if(o1.amount>o2.amount){
      1
    }else if(o1.amount == o2.amount){
      0
    }else{
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
    Collections.sort(orders,new Comparator[Order] {
      override def compare(o1: Order, o2: Order): Int = OrderCompare.compare(o1,o2)
    })

    // 打印排序的结果
    println(orders)

  }

}
