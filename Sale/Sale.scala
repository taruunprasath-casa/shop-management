package Sale

import Model.Product
import Inventory.Inventory
import Bill.Bill

object Sale {
  def processSale(data: String): String = {
    val entries = data.split(';').map(_.split('|')).map {
      case Array(pid, qty) => (pid.toInt, qty.toInt)
    }

    val billItems = entries.flatMap{ case (pid, qty) =>
      Inventory.inventory.get(pid).map { product =>
        if (product.quantity >= qty) {
          product.quantity -= qty
          (product, qty)
        } else {
          throw new RuntimeException(s"Insufficient stock for product ID $pid")
        }
      }
    }

    Bill.generateBill(billItems.toList)
  }
}
