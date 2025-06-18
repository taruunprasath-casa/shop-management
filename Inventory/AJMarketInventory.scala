package Inventory

import scala.collection.mutable

class AJMarketInventory(var productId: Int, var productName: String, var quantity: Int, var price: Double) {
  def displayProduct(): Unit = {
    println(s"Product ID: $productId | Name: $productName | Quantity: $quantity | Price: ₹$price")
  }

  def validateProductId(): Boolean = productId > 0

  def validateProductQuantity(): Boolean = quantity >= 0

  def updateProduct(newQuantity: Int, newPrice: Double): Unit = {
    if (validateProductId() && newQuantity >= 0 && newPrice >= 0) {
      this.quantity = newQuantity
      this.price = newPrice
      println(s"Product updated: $productName | New Quantity: $quantity | New Price: ₹$price")
      println("Inventory updated successfully.")
    } else {
      println("Invalid update parameters.")
    }
  }
}

object AJMarketInventory {

  class Product(val productId: Int, val productName: String, var quantity: Int, val pricePerUnit: Double)

  var inventory: mutable.Map[Int, Product] = mutable.Map()

  def handleInventory(input: String): Unit = {
    var parts = input.stripPrefix("INVENTORY=>").split('|')
    if (parts.length != 4) {
      println("Invalid INVENTORY format.")
      return
    }

    var productId = parts(0).toInt
    var productName = parts(1)
    var quantity = parts(2).toInt
    var price = parts(3).toDouble

    inventory.get(productId) match {
      case Some(existingProduct) =>
        existingProduct.quantity += quantity
      case None =>
        var product = new Product(productId, productName, quantity, price)
        inventory(productId) = product
    }

    println("Inventory Updated.")
  }

  def printAllInventory(): Unit = {
    inventory.values.foreach(p =>
      println(s"Product ID: ${p.productId} | Name: ${p.productName} | Quantity: ${p.quantity} | Price: ₹${p.pricePerUnit}")
    )
  }
}
