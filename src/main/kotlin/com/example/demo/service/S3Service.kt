package com.example.demo.service

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.S3ClientOptions
import com.amazonaws.services.s3.model.GetObjectRequest
import com.example.demo.out.client.Bear
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File

@Component
class S3Service (
        @Value("aws.s3.endpoint")
        val endpoint: String,
        @Value("aws.s3.accesskey")
        val accessKey: String,
        @Value("aws.s3.secretkey")
        val secretKey: String,
        @Value("aws.s3.bucketname")
        val bucketName: String,
        ) {

    fun initAmazonS3Client(
            endpoint: String = this.endpoint,
            accessKey: String = this.accessKey,
            secretKey: String = this.secretKey
    ) =
            AmazonS3Client(
                    BasicAWSCredentials(accessKey, secretKey)
            ).apply {
                setEndpoint(endpoint).apply {
                    println("S3 endpoint is ${endpoint}")
                }
                setS3ClientOptions(
                        S3ClientOptions.builder()
                                .setPathStyleAccess(true).build()
                )
            }
    fun objectFromS3(
            s3Client: AmazonS3Client,
            bucketName: String = this.bucketName,
            targetFilename: String,
            pathToDownload: String
    ) =
            s3Client
                    .getObject(GetObjectRequest(bucketName, targetFilename))
                    .objectContent
                    .readAllBytes()



    fun saveObjectToS3(
            s3Client : AmazonS3Client,
            bucketName : String = this.bucketName,
            key : String,
            stringfyedObject : String

    ) = s3Client.putObject(bucketName, key, stringfyedObject)
}