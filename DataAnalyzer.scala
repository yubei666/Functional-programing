// Name: Qi Zhou, Xiuzhu Li, Bhuwan Bista
// DataAnalyzer object: Provides data analysis and filtering features.

object DataAnalyzer {
  import DataLoader.data

  private def printStats(values: Seq[Double]): Unit = {
    println(s"Mean: ${Utils.mean(values)}")
    println(s"Median: ${Utils.median(values)}")
    println(s"Mode: ${Utils.mode(values)}")
    println(s"Range: ${Utils.range(values)}")
    println(s"Midrange: ${Utils.midrange(values)}")
  }

  def analyze(): Unit = {
    if (data.isEmpty) {
      println("No data loaded.")
      return
    }

    data.groupBy(_.energyType).foreach {
      case (energyType, records) =>
        val values = records.map(_.value)
        println(s"Statistics for energy type: $energyType")
        printStats(values.toSeq)  
    }
  }

  // Allows searching records by date and sorting them by value.
  def searchAndSort(): Unit = {
    println("Enter date to search (DD/MM/YYYY):")
    val inputDate = scala.io.StdIn.readLine()

    if (!Utils.validDateFormat(inputDate)) {
      println("Invalid date format. Please enter as DD/MM/YYYY")
      return
    }

    val filteredRecords = data.filter(_.date == inputDate)

    if (filteredRecords.isEmpty) {
      println("No data found for that date.")
    } else {
      println("Sort by value ascending? (y/n):")
      val ascending = scala.io.StdIn.readLine().toLowerCase == "y"
      val sorted = if (ascending)
        filteredRecords.sortBy(_.value)
      else
        filteredRecords.sortBy(r => -r.value)

      sorted.foreach(println)
    }
  }
}