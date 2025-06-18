error id: file://<WORKSPACE>/AJMarketApp.scala:`<none>`.
file://<WORKSPACE>/AJMarketApp.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Inventory.AJMarketInventory#
	 -AJMarketInventory#
	 -scala/Predef.AJMarketInventory#
offset: 326
uri: file://<WORKSPACE>/AJMarketApp.scala
text:
```scala
import scala.io.StdIn.readLine
import scala.collection.mutable
import Inventory.AJMarketInventory
import Stock.AJMarketStock
import Bill.AJMarketBill
import Sale.AJMarketSale

object AJMarketApp {
  def main(args: Array[String]): Unit = {
    println("Welcome to AJMarket!")
    val inventory = mutable.Map[Int, AJMarketInvent@@ory]()
    val stock = mutable.Map[Int, AJMarketStock]()
    val sales = mutable.ListBuffer[Bill.Sale]()

    var running = true
    while (running) {
      println("Enter command (INVENTORY, STOCK, SALE, BILL, EXIT):")
      val input = readLine().trim.toUpperCase

      input match {
        case "INVENTORY" =>
          println("Enter inventory details (format: INVENTORY=>productId|productName|quantity|price):")
          val inventoryInput = readLine()
          AJMarketInventory.handleInventory(inventoryInput)

        case "STOCK" =>
          println("Enter stock details (format: STOCK=>productId|quantity):")
          val stockInput = readLine()
          AJMarketStock.handleStock(stockInput)

        case "SALE" =>
          println("Enter sale details (format: SALE=>productId|quantity):")
          val saleInput = readLine()
          sales ++= AJMarketSale.parseSales(saleInput).map(sale => Bill.Sale(sale.productId, sale.quantity, sale.price))

        case "BILL" =>
          if (sales.nonEmpty) {
            val bill = new AJMarketBill(sales.toArray, inventory)
            bill.printBill()
            sales.clear()
          } else {
            println("No sales to generate bill.")
          }

        case "EXIT" =>
          running = false

        case _ =>
          println("Invalid command. Please try again.")
      }
    }
    println("Thank you for using AJMarket!")
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.