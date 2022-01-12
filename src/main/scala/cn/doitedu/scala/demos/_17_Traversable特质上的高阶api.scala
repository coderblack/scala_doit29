package cn.doitedu.scala.demos

import java.sql.DriverManager

object _17_Traversable特质上的高阶api {
  def main(args: Array[String]): Unit = {

    val arr1 = Array(1,2,3,4,5)
    val arr2 = Array(("a",2),("b",3),("a",1),("b",2))

    // foreach
    arr1.foreach(x=>println(x))


    // 利用foreach算子，将集合中的元素插入mysql
    val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","123456")
    val statement = conn.prepareStatement("insert into suibian values ( ? )")
    arr1.foreach(x=>{
      statement.setInt(1,x)
      statement.execute()
    })
    statement.close()
    conn.close()

    // 随堂练习
    val tuples: Array[(Int, String, Int, String)] = Array((1, "a", 20, "male"), (2, "b", 30, "female"), (3, "c", 18, "female"), (4, "d", 22, "male"))
    // 将上面这个数组中的元素全部插入到mysql中






  }
}
