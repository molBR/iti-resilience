package com.example.demo.service

import com.example.demo.out.client.Bear
import com.example.demo.out.client.BearClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import java.time.Duration


@Service
class BearService(val bearClient: BearClient, val redisService: RedisService) {



    @CircuitBreaker(name = "RESILIENCE4J_INSTANCE_NAME", fallbackMethod = "fbMethod")
    fun getBears() : Bear{

        val bearObj = bearClient.getBearsClient();
        redisService.set("BEARS", bearObj, Duration.ofDays(30))
        return bearObj
    }

    fun fbMethod(e : Exception) : Bear{

        if(redisService.check("BEARS")){
            val bear = redisService.get("BEARS") as Bear
            return bear
        }else{
            throw e
        }


    }
}