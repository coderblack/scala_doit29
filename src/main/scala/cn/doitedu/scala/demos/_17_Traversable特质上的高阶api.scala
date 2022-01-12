package cn.doitedu.scala.demos

import java.sql.DriverManager

object _17_Traversable特质上的高阶api {
  def main(args: Array[String]): Unit = {

    val arr1 = Array(1, 2, 3, 4, 5, 6, 8, 7)
    val arr2 = Array(("a", 2), ("b", 3), ("a", 1), ("b", 2))
    val tuples: Array[(Int, String, Int, String)] = Array(
      (1, "a", 20, "male"),
      (2, "b", 30, "female"),
      (3, "c", 18, "female"),
      (4, "d", 22, "male")
    )

    /**
     * foreach
     */
    arr1.foreach(x => println(x))

    // 利用foreach算子，将集合中的元素插入mysql
    val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "123456")
    val statement = conn.prepareStatement("insert into suibian values ( ? )")
    arr1.foreach(x => {
      statement.setInt(1, x)
      //statement.execute()
    })
    statement.close()
    conn.close()

    // 随堂练习

    // 将上面这个数组中的元素全部插入到mysql中
    val conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "123456")
    val statement2 = conn2.prepareStatement("insert into scala values ( ?,?,?,? )")

    tuples.foreach(tp => {
      statement2.setInt(1, tp._1)
      statement2.setString(2, tp._2)
      statement2.setInt(3, tp._3)
      statement2.setString(4, tp._4)
      // statement2.execute()
    })
    statement2.close()
    conn2.close()


    /**
     * map 映射
     */
    // 将原来的2元组数组，变成一个3元组数组
    val tmp1 = arr2.map(tp => (tp._1, tp._1.hashCode, tp._2))
    // 将("a",2) ==> "a->2"
    val tmp2 = arr2.map(tp => tp._1 + "->" + tp._2)


    /**
     * flatten 打散（压平）
     */
    val arr3 = Array(Array(3, 80), Array(90, 5, 6), Array(7, 20))
    val tmp3 = arr3.flatten // Array[3,80,90,5,6,7,20]

    // 字符串数组 ==> 词数组
    val arr4 = Array("a b c", "b b c", "a c b")
    val tmp4: Array[Array[String]] = arr4.map(s => s.split(" ")) // Array[Array[a,b,c],Array[b,b,c],Array[a,cb]]
    val tmp5: Array[String] = tmp4.flatten // Array[a,b,c,b,b,c,a,c,b]

    /**
     * flatMap:  映射+打散
     */
    val tmp6: Array[String] = arr4.flatMap(s => s.split(" ")) // Array[a,b,c,b,b,c,a,c,b]

    /**
     * filter 过滤
     */
    // 留下偶数
    val tmp7: Array[Int] = arr1.filter(p => p % 2 == 0)
    // 留下奇数
    val tmp8: Array[Int] = arr1.filterNot(p => p % 2 == 0)
    // 留下所有小于7的元素
    arr1.filter(p => p < 7)


    /**
     * min 求最小值
     * max 求最大值
     * sum 求和
     */
    val min: Int = arr1.min
    val max: Int = arr1.max
    val sum: Int = arr1.sum


    /**
     * minBy ： 依据指定字段求最小
     * maxBy ： 依据指定字段求最大
     */
    // 找年龄最小的那个人： (3,"c",18,"female")
    val minElement: (Int, String, Int, String) = tuples.minBy(tp => tp._3)
    // 注意区别！！！！：min求最小元素，直接按整个元素去对比
    val min1: (Int, String, Int, String) = tuples.min // 这样写，要求你的集合中的元素是可比较的（Ordered）
    val min2: Int = tuples.map(tp => tp._3).min

    // 找id最大的那个人 : (4,"d",22,"male"
    val elementMax: (Int, String, Int, String) = tuples.maxBy(tp => tp._1)


    /**
     * count  求满足条件的元素个数，类似于 sql中的函数 count(if())
     */
    // 统计arr1中奇数个数
    arr1.count(p => p % 2 == 1) // select count(if(p%2=1,1,null)) from table

    /*
     *  zip  两个数组对应脚标上的元素拉成一个一个的元组
     */
    val features1 = Array(180, 78, 38, 1, 35000)
    val features2 = Array(182, 80, 36, 1, 32000)

    // 求上面两个特征向量之间的欧几里得距离
    var square: Double = 0
    for (i <- 0 until features1.length) {
      square += Math.pow(features1(i) - features2(i), 2)
    }
    val distance1 = Math.pow(square, 0.5)

    // 用scala的集合高阶api解决
    val zipped = features1.zip(features2) // Array[(180,182),(78,80),(38,36),(1,1),(35000,32000)]
    val doubles = zipped.map(tp => Math.pow(tp._1 - tp._2, 2)) // Array[ 4,4,4,0,9000000]
    val distance2 = Math.pow(doubles.sum, 0.5)

    // 一行写完版
    //Math.pow(features1.zip(features2).map(tp=>Math.pow(tp._1-tp._2,2)).sum,0.5)

    /**
     * zipWithIndex  ：将每个元素与它的脚标号  ，拉成一个一个的元组
     */
    val tmp9: Array[(Int, Int)] = arr1.zipWithIndex // (1,0),(2,1),(3,2),(4,3),(5,4),(6,5),(8,6),(7,7)
    println(tmp9.mkString(","))
    // 留随堂练习： 留下arr1中 元素值>索引号 的数据
    val ints: Array[Int] = arr1.zipWithIndex.filter(tp => tp._1 > tp._2).map(tp => tp._1)

    /**
     * groupBy： 分组
     */
    // 把arr2中单词相同数据分到同一组
    // 结果解释： HashMap，key是分组字段、value是同一组中的所有数据
    val by1: Map[String, Array[(String, Int)]] = arr2.groupBy(tp => tp._1)
    // 把tuples中的数据按性别分组
    val byGender: Map[String, Array[(Int, String, Int, String)]] = tuples.groupBy(tp => tp._4)

    /**
     * grouped ： 按指定的组大小，分组
     */
    val iter: Iterator[Array[Int]] = arr1.grouped(3) // 按3个一组 :  [1,2,3],  [4,5,6] ,[8,7]
    iter.foreach(arr => println(arr.mkString("[", ",", "]")))


    /**
     * foldLeft ：向左折叠
     */
    // 第一个参数是，折叠起始的初始值
    // 第二个参数是，一个折叠逻辑的函数
    //                函数中的第1个参数： 是上一次的折叠结果 ;
    //                函数中的第2个参数： 是本次迭代到的数据中的元素
    // 将arr1中的元素做累加
    val accSum: Int = arr1.foldLeft(10)((res, ele) => res + ele)
    // 把arr1数组变成一个聚合值： "12345687"
    val str: String = arr1.foldLeft("")((res, ele) => res + ele)
    // println("accSum: " + accSum)
    println(s"accSum: ${accSum}")
    println(s"str: ${str}")

    /**
     * fold ：底层调用的就是foldLeft，只不过要求： 原集合中元素是什么类型，聚合出来的结果就是什么类型
     */
    // 与前面写的flodLeft一样
    val accSum1 = arr1.fold(10)((res, ele) => res + ele)


    /**
     * reduce :就是foldLeft，只不过内部帮你自动传了第一次折叠的初始值 0
     */
    //val accSum2 = arr1.reduce((acc:Int, ele:Int) => { acc + ele })
    val accSum2 = arr1.reduce(_ + _) // 上面的函数的超精简写法

    /**
     * reduceLeft : 将元素聚合成元素的超类结果
     */
    val accSum3 = arr1.reduceLeft(_ + _)


    /**
     * 两个集合之间的运算：
     * 求交集
     * 求并集
     * 求差集
     */
    val stu1 = Array("刘飞", "孙雨辰", "陈阳", "李宝杰", "张如梦")
    val stu2 = Array("洪亮", "李平", "陈阳", "李宝杰", "梦圆")

    // 求交集
    val intersectArray: Array[String] = stu1.intersect(stu2) // Array["陈阳","李宝杰"]
    // 求并集 (会自动去重）
    val unionArray = stu1.union(stu2) // Array["刘飞","孙雨辰","陈阳","李宝杰","张如梦",洪亮","李平","梦圆"]
    // 求差集 （从集合1中剔除掉存在于集合2的元素）
    val diffArray = stu1.diff(stu2) // Array["刘飞","孙雨辰","张如梦"]

    /**
     * 切片
     */
    val sliceArray: Array[String] = stu1.slice(2, 8)
    println(sliceArray.mkString(","))


    /**
     * sortBy ：按指定的字段排序
     */
    // 对tuples按年龄排序
    tuples.sortBy(tp => tp._3)
    // 对tuples按性别排序
    tuples.sortBy(_._4)
    // 对tuples排序： 先按性别，性别相同的人按年龄
    tuples.sortBy(tp=> (tp._4, tp._3) )

    // wordCount -- 模仿 mapreduce 模型
    val wc = Array("a a a b c", "a b c c d d", "a d c")
    val t1: Array[Array[String]] = wc.map(_.split(" "))
    val t2: Array[(String, Int)] = t1.flatMap(arr => arr.map((_, 1)))
    val t3: Map[String, Array[(String, Int)]] = t2.groupBy(_._1)
    val t4: Map[String, Int] = t3.map(tp => (tp._1, tp._2.map(_._2).sum))
    println(t4)

    // haha
  }
}
