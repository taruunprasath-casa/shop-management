package ajmarketstock

class AJMarketStock(var productId: Int, var productName: String, var quantity: Int, var price: Double) {

  def displayStock(): Unit = {
    println(s"Product ID: $productId | Name: $productName | Quantity: $quantity | Price: ₹$price")
  }

  def validateProductId(): Boolean = {
    if (productId > 0) true
    else {
      println("Invalid Product ID. It must be greater than 0.")
      false
    }
  }

  def validateProductQuantity(): Boolean = {
    if (quantity >= 0) true
    else {
      println("Invalid Quantity. It cannot be negative.")
      false
    }
  }

  def updateStock(newQuantity: Int, newPrice: Double): Unit = {
    if (validateProductId() && newQuantity >= 0 && newPrice >= 0) {
      this.quantity = newQuantity
      this.price = newPrice
      println(s"Stock updated: $productName | New Quantity: $quantity | New Price: ₹$price")
      println("Stock updated successfully.")
    } else {
      println("Invalid update parameters.")
    }
  }
}

object AJMarketStockService {

  private val inventory: mutable.Map[Int, AJMarketStock] = mutable.Map()

  def handleInventory(input: String): Unit = {
    val parts = input.stripPrefix("INVENTORY=>").split('|')
    if (parts.length != 4) {
      println("Invalid INVENTORY format.")
      return
    }

    val productId = parts(0).toInt
    val productName = parts(1)
    val quantity = parts(2).toInt
    val price = parts(3).toDouble

    inventory.get(productId) match {
      case Some(existingProduct) =>
        existingProduct.quantity += quantity
        existingProduct.price = price
      case None =>
        inventory(productId) = new AJMarketStock(productId, productName, quantity, price)
    }

    println("Inventory Updated.")
  }

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