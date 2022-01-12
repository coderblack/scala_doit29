package cn.doitedu.scala.exercise

import java.io.{BufferedWriter, FileWriter}
import scala.io.Source
import scala.math.BigDecimal.RoundingMode

/**
 * 需求：有如下数据
 * movies.dat
 * 电影id::电影名称::电影风格
 * 17::Sense and Sensibility (1995)::Drama|Romance
 *
 * users.dat
 * 用户id::性别::年龄
 * 34::F::18::0::02135
 *
 *
 * ratings.dat
 * 用户id::电影id::评分值::评分时间
 * 1::661::3::978302109
 *
 * 请统计：
 * 1）   每部电影的平均得分  -> 并将结果输出到文件
 * 2)    每个用户评过的电影总数  -> 并将结果输出到文件
 * 3）   每个用户评分最高的前3部电影（用户，电影信息，评分值） -> 并将结果输出到文件
 * 4）   哪些年份的电影评分（平均分）最高（前5个年份）
 * 要求用到case class
 * 尽量用高阶API
 */

case class Rate(uid: Int, movieId: Int, rate: Int, ts: Long)

object 综合练习1 {
  def main(args: Array[String]): Unit = {
    val lines: List[String] = Source.fromFile("data/ratings.dat").getLines().toList
    demand1(lines)
  }

  // 1）每部电影的平均得分  -> 并将结果输出到文件
  def demand1(lines: List[String]): Unit = {
    // 根据需求,按sql的模型去想：按电影id分组，然后聚合分数
    val dataList: List[Rate] = lines.map(s => {
      val split = s.split("::")

      val uid = split(0).toInt
      val movieId = split(1).toInt
      val rate = split(2).toInt
      val ts = split(3).toLong
      Rate(uid, movieId, rate, ts)
    })

    // 分组
    val groupByed: Map[Int, List[Rate]] = dataList.groupBy(r => r.movieId)

    // 求每一组的平均值
    val res: Map[Int, BigDecimal] = groupByed.map(tp => {
      val movieId = tp._1
      // 评分的总条数
      val rateCnt = tp._2.size
      // 评分的总分数
      val rateSum = tp._2.map(_.rate).sum // 把List[Rate]变成List[分数] ，再求sum

      val avgRate = BigDecimal.double2bigDecimal(rateSum.toDouble / rateCnt).setScale(2, RoundingMode.HALF_UP)

      (movieId, avgRate)
    })



    // 将结果输出到文件中
    /*for( (k,v) <- res  ){
      // 写出数据
    }*/
    val bw = new BufferedWriter(new FileWriter("data/movie_avg_rate.txt"))
    res.foreach(tp => {
      bw.write(tp._1 + "," + tp._2)
      bw.newLine() // 换行
    })
    bw.close()
  }
}
