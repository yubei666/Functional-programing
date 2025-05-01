//Menu object: Provides interactive menu for the user to choose system actions.

object Menu {
  def show(): Unit = {
    var continue = true
    while (continue) {
      println("""
        |Choose an option:
        |1. Load data from file
        |2. Show all data
        |3. Analyze data
        |4. Search and sort data
        |5. Error test
        |6. Exit
        |Enter choice:
        |""".stripMargin)
      scala.io.StdIn.readLine().trim match {
        case "1" => DataLoader.load("data/sample_data.csv")
        case "2" => DataLoader.display()
        case "3" => DataAnalyzer.analyze()
        case "4" => DataAnalyzer.searchAndSort()
        case "5" => ErrorHandler.testErrors()
        case "6" => continue = false
        case _   => println("Invalid choice.")
      }
    }
  }
}