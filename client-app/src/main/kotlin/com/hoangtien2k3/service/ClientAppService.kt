package com.hoangtien2k3.service

import com.hoangtien2k3.client.RestaurantServiceClient
import com.hoangtien2k3.dto.OrderResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class ClientAppService @Autowired constructor(private val restaurantServiceClient: RestaurantServiceClient){

    fun greeting(): String = "Welcome to Client App Service."

    fun checkOrderStatus(orderId: String): OrderResponseDTO? = restaurantServiceClient.fetchOrderStatus(orderId)

}