//Main object: Entry point of the REPS system.
//Displays welcome message and shows menu options.

object Main {
  def main(args: Array[String]): Unit = {
    println("Welcome to the Renewable Energy Plant System (REPS)")
    Menu.show()
  }
}
