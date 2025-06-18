package ajmarketsale

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
