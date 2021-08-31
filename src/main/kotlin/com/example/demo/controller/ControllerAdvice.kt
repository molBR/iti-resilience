package com.example.demo.controller

import com.example.demo.out.client.Bear
import com.example.demo.out.client.ClientException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ControllerAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(ClientException::class)])
    fun handleClientException(exception : ClientException) : ResponseEntity<ClientException> {
        return ResponseEntity.status(exception.statusCode).body(exception)
    }

}