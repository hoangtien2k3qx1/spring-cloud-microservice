package com.hoangtien2k3.dto

import org.springframework.http.HttpStatus

data class CustomErrorResponse(
    val status: HttpStatus,
    val errorMessage: String,
    val errorCode: String
)