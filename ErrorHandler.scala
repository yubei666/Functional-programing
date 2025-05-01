//ErrorHandler object: Simulates and handles example errors.

object ErrorHandler {
  def testErrors(): Unit = {
    println("Testing error: invalid date format")
    val wrongDate = "April 12, 2024"
    if (!Utils.validDateFormat(wrongDate))
      println(s"Invalid date format. Please enter the date in the format 'DD/MM/YYYY'. For example, enter '12/04/2024'.")

    println("Testing error: no data for selected date")
    val emptyDate = "15/04/2099"
    if (!DataLoader.data.exists(_.date == emptyDate))
      println(s"No available data for the selected date: $emptyDate. Please choose another date.")
  }
}