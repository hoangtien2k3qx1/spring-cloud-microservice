package com.hoangtien2k3.advice

import com.hoangtien2k3.dto.CustomErrorResponse
import com.hoangtien2k3.dto.GlobalErrorCode
import com.hoangtien2k3.exception.OrderNotFoundException
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Slf4j
class RestaurantServiceGlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException::class)
    fun handleOrderNotFoundException(ex: OrderNotFoundException): ResponseEntity<*> =
        ResponseEntity.internalServerError().body(
            ex.message?.let {
                CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, GlobalErrorCode.ERROR_ORDER_NOT_FOUND, it)
            }
        )


}