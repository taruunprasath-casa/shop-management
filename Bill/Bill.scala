package Bill

import Model.Product

object Bill {
  def generateBill(items: List[(Product, Int)]): String = {
    val header = "== Bill =="
    val body = items.map { case (product, qty) =>
      val netPrice = qty * product.price
      s"${product.id} - ${product.name} - $qty - ${product.price.toInt} - N/A - ${netPrice.toInt}"
    }
    print("\n")
    val total = items.map { case (product, qty) => qty * product.price }.sum.toInt

    s"$header\n$body\n== Total ==\n$total\n========"
  }
}
