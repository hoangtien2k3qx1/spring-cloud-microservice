package com.hoangtien2k3.dao

import com.hoangtien2k3.dto.OrderResponseDTO
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestaurantOrderDAO {

    fun generateRandomOrders(): Map<String, OrderResponseDTO> = mapOf(
        "35fds631" to OrderResponseDTO("35fds63", "Sony", 1, 199.0, Date(), "READY", 15),
        "9u71245h" to OrderResponseDTO("9u71245h", "Samsung", 2, 641.0, Date(), "PREPARING", 59),
        "37jbd832" to OrderResponseDTO("37jbd832", "Iphone", 1, 325.0, Date(), "DELIVERED", 0)
    )

    fun getOrders(orderId: String): OrderResponseDTO? = generateRandomOrders()[orderId]

}

fun main() {
    println("hoangtien2k3".toUpperCase())
}