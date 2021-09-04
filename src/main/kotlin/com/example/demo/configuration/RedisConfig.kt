package com.example.demo.configuration

import com.example.demo.out.client.Bear
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {

        return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Bear>? {
        val objectMapper = ObjectMapper()
        val serializer = Jackson2JsonRedisSerializer(Bear::class.java)
        serializer.setObjectMapper(objectMapper)

        val template = RedisTemplate<String, Bear>()
        template.setConnectionFactory(redisConnectionFactory())
        template.setDefaultSerializer(serializer)
        return template
    }
}