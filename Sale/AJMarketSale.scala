package Sale

class AJMarketSale(var productId: Int, var quantity: Int){
    this.productId = productId
    this.quantity = quantity

    def displaySale(): Unit = {
        println(s"Sale Details: Product ID: $productId | $quantity ; $productId | Quantity Sold: $quantity")
    }

    def handleSale(input: String): Unit = {
    var saleItems = input.stripPrefix("SALE=>").split(';').toList

    var sales = saleItems.map { item =>
    var Array(id, qty) = item.split('|').map(_.toInt)
    AJMarketSale(id, qty)
    }
 }   
}

case class Sale(productId: Int, quantity: Int, price: Double = 0.0)

object AJMarketSale {

  def parseSales(input: String): Seq[Sale] = {
    input.stripPrefix("SALE=>")
      .split(';')
      .toList
      .map { item =>
        val Array(id, qty, price) = item.split('|').map(_.toInt)
        Sale(id, qty, price = 0.0) 
      }
  }
}

