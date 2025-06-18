error id: file://<HOME>/Project/Shop%20Management/AJMarketInventory.scala:[1057..1057) in Input.VirtualFile("file://<HOME>/Project/Shop%20Management/AJMarketInventory.scala", "package ajmarketinventory

class AJMarketInventory(var productId: Int, var productName: String, var quantity: Int, var price: Double) {

    def displayProduct(): Unit = {
        println(s"Product ID: $productId | Name: $productName | Quantity: $quantity | Price: ₹$price")
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
            println(s"Product updated: $productName | New Quantity: $quantity | New Price: ₹$price")
            println("Inventory updated successfully.")
        }
    }

}

object
")
file://<HOME>/Project/Shop%20Management/file:<HOME>/Project/Shop%2520Management/AJMarketInventory.scala
file://<HOME>/Project/Shop%20Management/AJMarketInventory.scala:38: error: expected identifier; obtained eof

^
#### Short summary: 

expected identifier; obtained eof