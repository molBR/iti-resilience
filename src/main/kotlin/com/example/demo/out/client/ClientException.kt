package com.example.demo.out.client

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

data class ClientException  (
        val statusCode: HttpStatus,
        override val message: String,
        val errorCode: String
        ): RuntimeException()
