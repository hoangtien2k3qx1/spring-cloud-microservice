package com.hoangtien2k3.client

import com.hoangtien2k3.dto.OrderResponseDTO
import com.hoangtien2k3.exception.ClientAppServiceException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException

@Component
@Slf4j
class RestaurantServiceClient @Autowired constructor(
    private val webClientBuilder: WebClient.Builder
) {

    fun fetchOrderStatus(orderId: String): OrderResponseDTO? {
        return try {
            val response = webClientBuilder.build()
                .get()
                .uri("http://RESTAURANT-SERVICE/restaurant/orders/status/$orderId")
                .retrieve()
                .bodyToMono(OrderResponseDTO::class.java)
                .block()

            response ?: throw ClientAppServiceException("Received null response")
        } catch (errorException: WebClientResponseException) {
            throw ClientAppServiceException(errorException.responseBodyAsString)
        } catch (ex: Exception) {
            null
        }
    }

}