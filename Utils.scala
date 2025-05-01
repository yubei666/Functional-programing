
//Utils object: Provides helper functions for statistics and validation.

object Utils {
  def mean(values: Seq[Double]): Double = values.sum / values.size

  def median(values: Seq[Double]): Double = {
    val sorted = values.sorted
    val size = sorted.size
    if (size % 2 == 0) (sorted(size/2 - 1) + sorted(size/2)) / 2 else sorted(size/2)
  }

  def mode(values: Seq[Double]): Double = {
    values.groupBy(identity).mapValues(_.size).maxBy(_._2)._1
  }

  def range(values: Seq[Double]): Double = values.max - values.min

  def midrange(values: Seq[Double]): Double = (values.max + values.min) / 2


//Validates if the date matches DD/MM/YYYY format.

  def validDateFormat(date: String): Boolean =
    date.matches("\\d{2}/\\d{2}/\\d{4}")
}
