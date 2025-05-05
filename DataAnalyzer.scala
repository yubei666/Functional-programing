
//DataAnalyzer object: Provides data analysis and filtering features.

object DataAnalyzer {
  import DataLoader.data


//Performs statistical analysis grouped by energy type.

  def analyze(): Unit = {
    if (data.isEmpty) {
      println("No data loaded.")
      return
    }
    val grouped = data.groupBy(_.energyType)
    for ((etype, records) <- grouped) {
      val values = records.map(_.value)
      println(s"Mean: ${Utils.mean(values.toSeq)}")
      println(s"Median: ${Utils.median(values.toSeq)}")
      println(s"Mode: ${Utils.mode(values.toSeq)}")
      println(s"Range: ${Utils.range(values.toSeq)}")
      println(s"Midrange: ${Utils.midrange(values.toSeq)}")
    }
  }


//Allows searching records by date and sorting them by value.
   
  def searchAndSort(): Unit = {
    println("Enter date to search (DD/MM/YYYY):")
    val input = scala.io.StdIn.readLine()
    if (!Utils.validDateFormat(input)) {
      println("Invalid date format. Please enter as DD/MM/YYYY")
      return
    }
    val results = data.filter(_.date == input)
    if (results.isEmpty) println("No data found for that date.")
    else {
      println("Sort by value ascending? (y/n):")
      val sorted = if (scala.io.StdIn.readLine().toLowerCase == "y")
        results.sortBy(_.value)
      else results.sortBy(-_.value)
      sorted.foreach(println)
    }
  }
}
