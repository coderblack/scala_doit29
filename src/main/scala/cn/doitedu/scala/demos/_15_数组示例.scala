package cn.doitedu.scala.demos

case class Flower(id:Int)

object _15_数组示例 {

  def main(args: Array[String]): Unit = {

    // 构造数组
    val arr1 = Array.apply(10,2,30,40,50)
    val arr2 = Array(1,2,3,4,5)
    val arr3 = Array.empty[Int]  // 构造一个空数组，没有元素
    val arr4 = new Array[Double](3)  // 构造一个指定长度的数组,元素为指定类型的默认初始值
    val arr5 = new Array[Flower](3)  // 构造一个指定长度的数组,元素为指定类型的默认初始值
    println(arr5.mkString(","))

    // 数组长度不可变，但是数组中的元素是可以更新赋值的
    // 比如，把arr1的第二个元素修改为 20
    arr1(1) = 20

    // 从数组中获取指定位置上的值
    // 比如，取出arr1的第二个元素，进行打印
    println(arr1(1))

    // 数组的遍历
    for(i <- 0 until arr1.length ){
      arr1(i) = arr1(i) * 10
    }
    println(arr1.mkString(","))

    // for(int i: arr)
    // 利用 <- 迭代数组的角标集合
    for(i <- arr1.indices){ // indices返回的就是数组的所有角标的集合
      arr1(i) = arr1(i) * 10
    }

    // 直接迭代数组本身，取到每一个元素
    for(i <- arr1){
      println(i)
    }

    // 取 数组的长度
    println(arr1.length)

    /**
     * scala的集合上的高阶算子初体验
     * Array上也拥有scala的集合工具上的大量通用的高阶算子，如 map/flatmap/flatten/reduce/groupby/foldLeft ……
     */
    // foreach ： 对每个元素施加一个动作，所谓操作就是用户传入的函数
    arr1.foreach(  (g:Int)=>{ println(g+10) } )
    // arr1.foreach(  (g:Int)=> println(g+10)  )
    // arr1.foreach(  (g)=> println(g+10)  )
    // arr1.foreach(  g=> println(g+10)  )


    // map： 对每个元素施加一个映射操作，所谓映射操作就是将一个元素通过映射变成另外一个元素
    // 从而，将一个集合的每个元素做完映射后，得到一个新的集合
    val resArr: Array[String] = arr1.map(x => x + "_abc")
    println(resArr.mkString(","))



  }
}
