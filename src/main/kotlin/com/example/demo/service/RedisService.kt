package com.example.demo.service

import com.example.demo.out.client.Bear
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class RedisService  (val redisTemplate: RedisTemplate<String, Bear>) {


    fun get(key : String) : Any?{
        return redisTemplate.opsForValue().get(key)
    }

    fun set(key: String, value: Bear, duration: Duration)  {
        return redisTemplate.opsForValue().set(key, value, duration)
    }

    fun check(key: String) : Boolean{
        return redisTemplate.hasKey(key)
    }
}