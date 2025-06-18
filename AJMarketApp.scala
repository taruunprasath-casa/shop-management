import Inventory.Inventory
import Sale.Sale
import Stock.Stock
import scala.io.StdIn.readLine

object AJMarketApp extends App {
  var continue = true

  while (continue) {
    val input = readLine()

    input match {
      case s if s.startsWith("INVENTORY=>") =>
        val data = s.stripPrefix("INVENTORY=>")
        println(Inventory.updateInventory(data))

      case s if s.startsWith("SALE=>") =>
        val data = s.stripPrefix("SALE=>")
        try {
          println(Sale.processSale(data))
        } catch {
          case ex: RuntimeException => println(s"Error: ${ex.getMessage}")
        }

      case s if s.startsWith("STOCK=>") =>
        val productId = s.stripPrefix("STOCK=>").toInt
        println(Stock.checkStock(productId))

      case "EXIT" =>
        continue = false

      case _ =>
        println("Invalid Command.")
    }
  }
}
