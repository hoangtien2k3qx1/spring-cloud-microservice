package com.hoangtien2k3.dto

import java.util.Date

data class OrderResponseDTO(
    var orderId: String,
    var name: String,
    var qty: Int,
    var price: Double,
    var orderDate: Date,
    var status: String,
    var estimateDeliveryWindow: Int
)