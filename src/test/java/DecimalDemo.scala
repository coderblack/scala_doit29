import scala.math.BigDecimal.RoundingMode

object DecimalDemo {
  def main(args: Array[String]): Unit = {

    val decimal = BigDecimal.double2bigDecimal(5.665)
    val res: BigDecimal = decimal.setScale(2, RoundingMode.HALF_UP)
    println(res)

  }
}
