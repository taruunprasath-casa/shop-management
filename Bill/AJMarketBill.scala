package Bill

import scala.collection.mutable

class Product(val productId: Int, val productName: String, var quantity: Int, val price: Double)
case class Sale(productId: Int, quantity: Int)

class AJMarketBill(sales:Array[Sale], inventory: mutable.Map[Int, Product]) {
  def printBill(): Unit = {
    var totalAmount = 0.0
    println("== Bill ==")

    for (sale <- sales) {
      inventory.get(sale.productId) match {
        case Some(product) =>
          if (product.quantity >= sale.quantity) {
            val netPrice = product.price * sale.quantity
            product.quantity -= sale.quantity
            println(s"${product.productId} - ${product.productName} - ${sale.quantity} - ${product.price} - N/A - $netPrice")
            totalAmount += netPrice
          } else {
            println(s"${product.productId} - ${product.productName} - Out of stock for requested quantity")
          }
        case None =>
          println(s"${sale.productId} - Product not found.")
      }
    }

    println("== Total ==")
    println(totalAmount)
    println("========")
  }
}
