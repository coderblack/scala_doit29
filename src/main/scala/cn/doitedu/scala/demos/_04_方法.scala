package cn.doitedu.scala.demos

class Student{
  def sayMyName():Unit={
    println("my name is lilei")
  }
}


object _04_方法 {
  def main(args: Array[String]): Unit = {
    val res = sayHello("Tom White")
    multiplyPrint(5)
  }

  /**
   * 两数相加
   *
   * @param a
   * @param b
   * @return
   */
  def add(a: Int, b: Int): Int = {
    a + b
  }

  /**
   * 三数求最大
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  def max(a: Int, b: Int, c: Int): Int = {
    var mx = a
    if (b > mx) mx = b else if (c > mx) mx = c
    mx
  }

  def sayHello(name: String): Unit = {
    println("hello " + name)
  }

  def talk(): Unit = {
    println("今天的天气真好，天下居然掉水")
  }

  /**
   * 传入一个 1 ~ 9之间的参数n
   * 如果传入的参数n超过了9，则打印“不听话的宝宝，下次乖点，参数要<=9"
   * 如果传入的参数n合法，则打印乘法表到第 n行
   */
  def multiplyPrint(n: Int): Unit = {
    if (n < 1 || n > 9) {
      println("参数不合法，需要1~9之间")
    } else {
      for (i <- 1 to n; j <- 1 to i) {
        print(i + " X " + j + " = " + (i * j) + "\t")
        if (j == i) println
      }
    }
  }


}
