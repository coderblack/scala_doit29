package cn.doitedu.scala.demos

object _26_科里化 {

  def main(args: Array[String]): Unit = {

    // 科里化： 指的是，一个函数的多个参数，可以用多个参数列表来定义
    def add(x: Int, y: Int, z: Int) = x + y + z

    def add2(x: Int)(y: Int)(z: Int) = x + y + z

    add(1, 2, 3)
    add2(10)(20)(30)

    /**
     * 意义 ： 利于 类型推断
     */
    def addF[T](x: T, f: T => T): T = f(x)

    addF(10, (x: Int) => x + 10)
    //addF(10,x=>x+10) // 就算第一个参数已经传入了10，也无法推断第二个参数的T泛型的类型
    //addF("aaa",x=>x.toUpper)  // 就算第一个参数已经传入了字符串，也无法推断第二个参数的T泛型的类型

    // 科里化能更好地让编译器进行类型推断
    def addCurried[T](x: T)(f: T => T): T = f(x)


    /**
     * 意义： 减少参数传递
     */
    val func1 = (x: Int, y: Int) => x + y
    val func2 = (x: Int) => {
      (y: Int) => x + y
    }
    val f2: Int => Int = func2(10) // y=>y+10
    val res = f2(20) // 30

    // 假设有场景： 要调用上面的函数，求销售价格
    // 求销售价格的时候，需要传入一个成本价和利润，而某一个品类的成本价都是固定的
    func1(10,5)
    func1(10,6)
    func1(10,7)

    val price = func2(10)  // 10这个成本价只要传10一次，后面就可以反复用
    price(5)
    price(6)
    price(7)

  }


}
