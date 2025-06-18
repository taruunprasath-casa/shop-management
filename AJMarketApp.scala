class AJMarketInventory(var productId: Int, var productName: String, var quantity: Int, var price: Double) {

    AJMarketInventory{
        this.productId = productId
        this.productName = productName
        this.quantity = quantity
        this.price = price
    }

    def displayProduct(): Unit = {
        println(s"Product ID: $productId, Name: $productName, Quantity: $quantity, Price: $$price")
    }

    def validateProductId(): Boolean = {
        if (productId > 0) {
            true
        } else {
            println("Invalid Product ID. It must be greater than 0.")
            false
        }
    }

    def validateProductQuantity(): Boolean = {
        if (quantity >= 0) {
            true
        } else {
            println("Invalid Quantity. It cannot be negative.")
            false
        }
    }
    def updateProduct(newQuantity: Int, newPrice: Double): Unit = {
        if(validateProductId()){
            this.quantity = newQuantity
            this.price = newPrice
            println(s"Product updated: $productName, New Quantity: $quantity, New Price: $$price")
        }
    }
}



object AJMarketApp {
    def main(args: Array[String]): Unit = {
        println("Welcome to AJMarket!")
    }
}