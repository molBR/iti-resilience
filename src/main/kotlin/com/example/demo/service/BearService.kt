package com.example.demo.service

import com.example.demo.out.client.Bear
import com.example.demo.out.client.BearClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service


@Service
class BearService(val bearClient: BearClient, val s3Service: S3Service) {

    val s3Client = s3Service.initAmazonS3Client();

    @CircuitBreaker(name = "RESILIENCE4J_INSTANCE_NAME", fallbackMethod = "fbMethod")
    fun getBears() : Bear{

        val bearObj = bearClient.getBearsClient();
        s3Service.saveObjectToS3(s3Client = s3Client, key = "bears", stringfyedObject = bearObj.toString())
        return bearObj
    }

    fun fbMethod(e : Exception) : Bear{

        s3Service.objectFromS3()

        throw e
    }
}