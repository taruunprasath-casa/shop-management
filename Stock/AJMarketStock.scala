package Stock
import scala.collection.mutable


class AJMarketStock(var productId: Int, var productName: String, var quantity: Int, var price: Double) {

  def displayStock(): Unit = {
    println(s"Product ID: $productId | Name: $productName | Quantity: $quantity | Price: ₹$price")
  }

  def updateStock(newQuantity: Int, newPrice: Double): Unit = {
    if (newQuantity >= 0 && newPrice >= 0) {
      this.quantity = newQuantity
      this.price = newPrice
      println(s"Stock updated: $productName | New Quantity: $quantity | New Price: ₹$price")
      println("Stock updated successfully.")
    } else {
      println("Invalid update parameters.")
    }
  }
}

object AJMarketStock{

  private var inventory: mutable.Map[Int, AJMarketStock] = mutable.Map()

  def handleStock(input: String): Unit = {
    val productId = input.stripPrefix("STOCK=>").trim.toInt
    inventory.get(productId) match {
      case Some(product) => println(s"${product.productName} - ${product.quantity}")
      case None => println("Product not found.")
    }
  }

  def printAllStock(): Unit = {
    inventory.values.foreach(_.displayStock())
  }
}