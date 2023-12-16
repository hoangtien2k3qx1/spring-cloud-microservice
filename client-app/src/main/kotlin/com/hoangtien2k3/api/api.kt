package com.hoangtien2k3.api

import com.hoangtien2k3.dto.OrderResponseDTO
import com.hoangtien2k3.service.ClientAppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app")
class api @Autowired constructor(private val clientAppService: ClientAppService){

    @GetMapping("/home")
    fun greetingMessage(): String = clientAppService.greeting()

    @GetMapping("/{orderId}")
    fun checkOrderStatus(@PathVariable orderId: String): OrderResponseDTO? = clientAppService.checkOrderStatus(orderId)

}