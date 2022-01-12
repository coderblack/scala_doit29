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
     * count
     */
    // 统计arr1中奇数个数
    arr1.count(p => p % 2 == 1) // select count(if(p%2=1,1,null)) from table

    /*
     *  zip  两个数组对应脚标上的元素拉成一个一个的元组
     */
    val features1 = Array(180,78,38,1,35000)
    val features2 = Array(182,80,36,1,32000)

    // 求上面两个特征向量之间的欧几里得距离
    var square:Double = 0
    for(i<- 0 until features1.length){
      square += Math.pow(features1(i)-features2(i),2)
    }
    val distance1 = Math.pow(square, 0.5)

    // 用scala的集合高阶api解决
    val zipped = features1.zip(features2)  // Array[(180,182),(78,80),(38,36),(1,1),(35000,32000)]
    val doubles = zipped.map(tp => Math.pow(tp._1 - tp._2, 2))  // Array[ 4,4,4,0,9000000]
    val distance2 = Math.pow(doubles.sum, 0.5)

    // 一行写完版
    //Math.pow(features1.zip(features2).map(tp=>Math.pow(tp._1-tp._2,2)).sum,0.5)

    /**
     * zipWithIndex
     */
    val tmp9: Array[(Int, Int)] = arr1.zipWithIndex // (1,0),(2,1),(3,2),(4,3),(5,4),(6,5),(8,6),(7,7)
    println(tmp9.mkString(","))
    // 留随堂练习：  下arr1中元素值>索引号的数据
    val ints: Array[Int] = arr1.zipWithIndex.filter(tp => tp._1 > tp._2).map(tp => tp._1)





  }
}
