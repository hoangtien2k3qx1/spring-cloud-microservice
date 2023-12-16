package com.hoangtien2k3.advice

import com.fasterxml.jackson.databind.ObjectMapper
import com.hoangtien2k3.dto.CustomErrorResponse
import com.hoangtien2k3.exception.ClientAppServiceException
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Slf4j
class ClientAppServiceGlobalExceptionHandler {

    @ExceptionHandler(ClientAppServiceException::class)
    fun handleClientAppServiceException(ex: ClientAppServiceException): ResponseEntity<*> {
        val errorResponse = ObjectMapper().readValue(ex.message, CustomErrorResponse::class.java)
        return ResponseEntity.internalServerError().body(errorResponse)
    }

}