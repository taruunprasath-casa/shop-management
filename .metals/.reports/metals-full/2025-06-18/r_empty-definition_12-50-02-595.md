error id: file://<HOME>/Project/Shop%20Management/AJMarketBill.scala:scala/Some.
file://<HOME>/Project/Shop%20Management/AJMarketBill.scala
empty definition using pc, found symbol in pc: scala/Some.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Some.
	 -Some#
	 -Some().
	 -scala/Predef.Some.
	 -scala/Predef.Some#
	 -scala/Predef.Some().
offset: 281
uri: file://<HOME>/Project/Shop%20Management/AJMarketBill.scala
text:
```scala
package ajmarketbill


class AJMarketBill(sales: Seq[AJMarketSale.Sale], inventory: mutable.Map[Int, Product]) {
  def printBill(): Unit = {
    var totalAmount = 0.0
    println("== Bill ==")

    for (sale <- sales) {
      inventory.get(sale.productId) match {
        case Some@@(product) =>
          if (product.quantity >= sale.quantity) {
            val netPrice = product.pricePerUnit * sale.quantity
            product.quantity -= sale.quantity
            println(s"${product.productId} - ${product.productName} - ${sale.quantity} - ${product.pricePerUnit} - N/A - $netPrice")
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Some.