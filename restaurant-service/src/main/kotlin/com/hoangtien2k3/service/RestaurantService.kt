package com.hoangtien2k3.service

import com.hoangtien2k3.dao.RestaurantOrderDAO
import com.hoangtien2k3.dto.OrderResponseDTO
import com.hoangtien2k3.exception.OrderNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestaurantService @Autowired constructor(private val restaurantOrderDAO: RestaurantOrderDAO) {

    fun greeting(): String = "Welcome to restaurant service."

    fun getOrder(orderId: String): OrderResponseDTO {
        return restaurantOrderDAO.getOrders(orderId)?.let { orderResponseDTO ->
            orderResponseDTO
        } ?: throw OrderNotFoundException("Order not found with id $orderId")
    }

}