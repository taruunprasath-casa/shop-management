error id: file://<HOME>/Project/Shop%20Management/AJMarketBill.scala:[44..49) in Input.VirtualFile("file://<HOME>/Project/Shop%20Management/AJMarketBill.scala", "package ajmarketbill
package ajmarketsale.

class AJMarketBill(sales: Seq[Sale], inventory: scala.collection.mutable.Map[Int, Product]) {
  def printBill(): Unit = {
    var totalAmount = 0
    println("== Bill ==")
    for (sale <- sales) {
      inventory.get(sale.productId) match {
        case Some(product) =>
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
}")
file://<HOME>/Project/Shop%20Management/file:<HOME>/Project/Shop%2520Management/AJMarketBill.scala
file://<HOME>/Project/Shop%20Management/AJMarketBill.scala:4: error: expected identifier; obtained class
class AJMarketBill(sales: Seq[Sale], inventory: scala.collection.mutable.Map[Int, Product]) {
^
#### Short summary: 

expected identifier; obtained class