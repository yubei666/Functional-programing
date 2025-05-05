//Name: Qi Zhou, Xiuzhu Li
//Menu object: Provides interactive menu for the user to choose system actions.

object Menu {
  def show(): Unit = {
    def menuLoop(): Unit = {
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
        case "1" =>
          DataLoader.load("data3.csv")
          menuLoop()
        case "2" =>
          DataLoader.display()
          menuLoop()
        case "3" =>
          DataAnalyzer.analyze()
          menuLoop()
        case "4" =>
          DataAnalyzer.searchAndSort()
          menuLoop()
        case "5" =>
          ErrorHandler.testErrors()
          menuLoop()
        case "6" =>
          () 
        case _ =>
          println("Invalid choice.")
          menuLoop()
      }
    }

    menuLoop() 
  }
}