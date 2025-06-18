import scala.io.StdIn.readLine
import scala.collection.mutable
import Inventory.AJMarketInventory
import Stock.AJMarketStock
import Bill.AJMarketBill

object AJMarketApp {
    def main(args: Array[String]): Unit = {
        println("Welcome to AJMarket!")
        val inventory = mutable.Map[Int, AJMarketInventory]()
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
                    println("Enter stock details (format: STOCK=>productId|productName|quantity|price):")
                    val stockInput = readLine()
                    AJMarketStock.handleInventory(stockInput)

                case "SALE" =>
                    println("Enter sale details (format: SALE=>productId|quantity;productId|quantity;...):")
                    val saleInput = readLine()
                    sales ++= Bill.AJMarketBill.parseSales(saleInput)

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