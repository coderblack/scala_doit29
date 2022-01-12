package cn.doitedu.scala.demos

import scala.collection.{immutable, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object _19_常用集合演示 {
  def main(args: Array[String]): Unit = {
    //<editor-fold desc="数组代码">
    /**
     * 数组(严格意义上不算集合）
     * 数组其实是一个不可变的（长度不可变）
     */
    val arr = Array(1, 2, 3, 4)

    // 在原来的数组的基础上添加元素形成新数组
    //val newArr1 = arr.:+(5)  // : 是分界线
    val newArr1 = arr :+ 5 // : 调方法的简写
    val newArr2 = arr.+:(5)
    println(newArr1.mkString(","))
    println(newArr2.mkString(","))

    val append = Array(7, 8, 9)
    val newArr3 = arr.++(append) // 把整个集合中的元素都添加到后面
    val newArr4 = arr.++:(append) // 把整个集合中的元素添加到左边
    println(newArr3.mkString(","))
    println(newArr4.mkString(","))
    //</editor-fold>


    //<editor-fold desc="List代码">
    /**
     * List ： 类似java中的ArrayList
     * 但scala中的List是一个不可变的集合（长度不可变）
     */
    val lst = List(1, 2, 2, 3, 4)
    val i = lst(0) // 根据脚标取数据
    val head: Int = lst.head // 取第一个元素  1
    val tail: List[Int] = lst.tail // tail是head以外的所有剩余的数据  [2,2,3,4]
    // Nil.head  // 会抛异常，因为Nil本质上是一个List[Nothing]，是没有任何元素可取的

    lst.updated(0, 10) // 将lst中的第0个元素设置为新值：10
    val size = lst.size // 得到lst的长度
    val listRev: List[Int] = lst.reverse // 将list反转得到新的list,不会修改原来的list
    val idx = lst.indexOf(2) // 找到第一个2所在的脚标
    val idx2 = lst.lastIndexOf(2) // 找到最后一个2所在的脚标
    val bool: Boolean = lst.contains(2) // 判断list是否包含指定元素
    val exists: Boolean = lst.exists(e => e > 3) // 判断list是否对指定的条件成立(存在>3的元素）！

    val newLst1 = lst.:+(5) // 往后面添加得到新list
    val newLst2 = lst.+:(5) // 往前面添加得到新list
    val newLst3 = lst.++:(append) // 将append集合中的所有元素全部添加到前面
    val newLst4 = lst.++(append) // 将append集合中的所有元素全部添加到后面
    println(newLst1)
    println(newLst2)
    println(newLst3)
    println(newLst4)

    /**
     * 添加元素得到新list，还可以用 :: 和 :::
     * 它们能让你更直观地感受到元素被添加到了哪一边
     */
    //lst.::(7)
    val newLst5 = 7 :: lst // 把7添加到前面得到新lst

    val prefix = List(7, 8, 9)
    // lst.:::(prefix)
    val newLst6 = prefix ::: lst // 拼接两个List

    // 在Nil的左边依次拼接上3个元素得到一个新list
    val newLst7 = 3 :: 5 :: 7 :: Nil // Nil就是一个空的List对象

    //</editor-fold>


    //<editor-fold desc="Seq代码">
    /**
     * Seq ： 用法与List几乎一样
     */
    val seq = Seq(1, 2, 3, 4)
    //</editor-fold>


    //<editor-fold desc="Range代码">
    /**
     * Range ： 它代表一个范围所包含的序列
     * 如果你要存储一个序列，那么用Range，空间占用都很小，它内部只存了序列的起始点和序列的结束点，以及步长
     */
    val range1 = Range(1, 100) // 不包含100

    // range.foreach(println)
    for (e <- range1) {
      println(e)
    }

    val range2 = Range(1, 100, 2) // 不包含100, 2是产生元素的间隔步长
    println(range2.take(5).mkString(","))

    val range3 = 1 to 100 // 调用整数上的to方法，来得到一个range序列，包含100
    val range4 = 1 until 100 // 调用整数上的until方法，来得到一个range序列，不包含100
    // for(i <- range4)    {      }
    // for(i <- 1 until 100){  }

    //</editor-fold>


    //<editor-fold desc="Map 代码">
    /**
     * Map: 类似于java中的hashmap
     * 不可变集合
     * 存储key-value对,无序（不存在什么脚标）
     */
    case class Tiger(id: Int, name: String)
    val mp1: Map[String, Int] = Map(("a", 1), ("b", 2), ("c", 3))
    val mp2: Map[Int, Int] = Map((10, 1), (20, 2), (30, 3))
    val mp3: Map[Tiger, Int] = Map((Tiger(1, "孟加拉虎"), 1000), (Tiger(2, "西伯利亚虎"), 2000), (Tiger(3, "东北虎"), 3000))
    val mp4 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(mp3)

    // 添加单个的kv对
    val newMp1 = mp1 + ("d" -> 4, "e" -> 5)
    val newMp2 = mp1 + (("d", 4))
    println(newMp2)

    // 一次性添加整个集合中的kv对到map中形成新的map
    val newMp3 = mp1.++:(List("d" -> 4, "e" -> 5, "f" -> 6))
    println(newMp3)

    // 取数据
    val maybeInt: Option[Int] = mp1.get("a") // Option就是一个盒子，它有两个实现：Some（代表盒子中有值）, None（代表空盒子）
    // 如果在None上调get，就会抛异常
    // 所以，从Option中拿我们要的值的时候，最好先做一个判断：是否是有值的
    if (maybeInt.isDefined) println(maybeInt.get)

    val value: Int = mp1.getOrElse("x", -1) // 优先去x对应的value值，如果x不存在，则返回默认值 -1
    println(value)

    println("------------------------")
    // 修改值
    val newMp4 = mp1.updated("a", 100)
    println(mp1)
    println(newMp4)

    // 删除元素
    val newMp5 = mp1 - "a"
    val newMp6 = mp1.-("a", "b")
    val newMp7 = mp1 -- List("a", "c")
    println(newMp5)
    println(newMp6)
    println(newMp7)

    // map的遍历
    println("--------------------------------------")
    // val strings: immutable.Iterable[String] = mp1.map(tp => tp._1.toUpperCase())
    for ((k, v) <- mp1) {
      println(k + "->" + v)
    }
    //</editor-fold>


    println("---------------涛哥是个刀子嘴豆腐心---------------------------")
    /**
     * ArrayBuffer：可变数组
     */
    val arrBuf1 = new ArrayBuffer(10) // 构造函数中的10是初始长度
    val arrBuf2 = ArrayBuffer(10, 30, 40, 50) // apply方法中是初始的元素

    // 与不可变数组不一样的api
    arrBuf2.+=:(60) // 在原来的数组的前面添加了一个元素
    arrBuf2.+=(60) // 在原来的数组的后面添加了一个元素
    arrBuf2.+=(70, 80, 90) // 在原来的数组的后面添加了3个元素

    arrBuf2.++=(List(55, 56, 57)) // 在后面添加上整个list中的所有元素
    arrBuf2.++=:(List(11, 12, 13)) // 在前面添加上整个list中的所有元素
    println(arrBuf2)


    /**
     * 可变list
     */
    val listBuf1 = new ListBuffer[Int]()
    val listBuf2 = ListBuffer(5, 6, 8)

    // api与前面的arrayBuffer几乎一样
    listBuf1.+=(6)


    /**
     * 可变Map
     */
    val hashMap1 = new mutable.HashMap[String,Int]()
    val hashMap2 = mutable.HashMap("a" -> 1, "b" -> 2)
    // 也可以增删改查元素
    hashMap2.++=(List("c"->3,"d"->4))
    println(hashMap2)

    // 判断一个key是否存在于hashmap中
    println(hashMap1.contains("c"))  // false
    println(hashMap2.contains("c"))  // true

    // 取hashmap的所有key
    val set: collection.Set[String] = hashMap2.keySet
    println(set)

  }
}
