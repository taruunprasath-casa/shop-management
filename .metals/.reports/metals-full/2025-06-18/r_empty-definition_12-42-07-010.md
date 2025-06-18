error id: file://<HOME>/Project/Shop%20Management/AJMarketBill.scala:`<none>`.
file://<HOME>/Project/Shop%20Management/AJMarketBill.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sale/quantity.
	 -sale/quantity#
	 -sale/quantity().
	 -scala/Predef.sale.quantity.
	 -scala/Predef.sale.quantity#
	 -scala/Predef.sale.quantity().
offset: 415
uri: file://<HOME>/Project/Shop%20Management/AJMarketBill.scala
text:
```scala
package ajmarketbill
import scala.collection.mutable
case class Sale(productId: Int, quantity: Int)

class AJMarketBill(sales: Seq[Sale], inventory: scala.collection.mutable.Map[Int, Product]) {
  def printBill(): Unit = {
    var totalAmount = 0
    println("== Bill ==")
    for (sale <- sales) {
      inventory.get(sale.productId) match {
        case Some(product) =>
          if (product.quantity >= sale.qua@@ntity) {
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

empty definition using pc, found symbol in pc: `<none>`.