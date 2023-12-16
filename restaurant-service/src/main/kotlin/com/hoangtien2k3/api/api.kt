package com.hoangtien2k3.api

import com.hoangtien2k3.dto.OrderResponseDTO
import com.hoangtien2k3.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurant")
class api @Autowired constructor(val service: RestaurantService) {

    @GetMapping
    fun greetingMessage() = service.greeting()

    @GetMapping("/orders/status/{orderId}")
    fun getOrder(@PathVariable orderId: String): OrderResponseDTO =  service.getOrder(orderId)

}