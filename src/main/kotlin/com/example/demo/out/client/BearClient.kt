package com.example.demo.out.client

import org.springframework.stereotype.Component
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.lang.Exception


@Component
class BearClient {

    var restTemplate = RestTemplate()

    fun getBearsClient() : Bear{
        try{
            return restTemplate.getForEntity("http://localhost:8082/bear", Bear::class.java).body!!

        }catch(e : HttpServerErrorException){
            throw  ClientException(
                    e.statusCode,
                    e.message!!,
                    "Feign Exception"
            )
        }


    }
}