import scala.io.Source
import scala.collection.mutable.ListBuffer


//Case class representing a single data record.
//@param date the date in DD/MM/YYYY format
//@param hour the hour of the day (0-23)
//@param energyType type of energy (e.g., Solar, Wind, Hydro)
//@param value energy generated in kWh

case class EnergyData(date: String, hour: Int, energyType: String, value: Double)


//DataLoader object: Handles loading data from CSV file and displaying records.

object DataLoader {
  var data: ListBuffer[EnergyData] = ListBuffer()


   //Loads data from a given CSV file path.
   //Assumes file format: Date,Hour,Type,Value

  def load(filename: String): Unit = {
    try {
      val source = Source.fromFile(filename)
      val lines = source.getLines().drop(1) // Skip header
      data.clear()
      for (line <- lines) {
        val cols = line.split(",").map(_.trim)
        data += EnergyData(cols(0), cols(1).toInt, cols(2), cols(3).toDouble)
      }
      source.close()
      println("Data loaded successfully.")
    } catch {
      case e: Exception => println("Error loading file: " + e.getMessage)
    }
  }


   //Displays all loaded data records.
  def display(): Unit = {
    if (data.isEmpty) println("No data loaded.")
    else data.foreach(println)
  }
}
