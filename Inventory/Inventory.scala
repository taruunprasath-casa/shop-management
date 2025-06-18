package Inventory

import Model.Product
import scala.collection.mutable

object Inventory {
  val inventory: mutable.Map[Int, Product] = mutable.Map()

  def updateInventory(data: String): String = {
    val Array(id, name, qty, price) = data.split('|')
    inventory(id.toInt) = Product(id.toInt, name, qty.toInt, price.toDouble)
    "Inventory Updated."
  }
}
