package ajmarketsale

class AJMarketSale(var productId: Int, var quantity: Int){
    this.productId = productId
    this.quantity = quantity

    def displaySale(): Unit = {
        println(s"Sale Details: Product ID: $productId | $quantity ; $productId | Quantity Sold: $quantity")
    }
}
