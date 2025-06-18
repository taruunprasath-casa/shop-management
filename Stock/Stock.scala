package Stock

import Inventory.Inventory

object Stock {
  def checkStock(productId: Int): String = {
    Inventory.inventory.get(productId) match {
      case Some(product) => s"${product.name} - ${product.quantity}"
      case None => "Product not found."
    }
  }
}
