package com.hoangtien2k3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class RestaurantServiceApplication

fun main(args: Array<String>) {
	runApplication<RestaurantServiceApplication>(*args)
}
