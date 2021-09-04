package com.example.demo.out.client

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.springframework.data.annotation.Id
import java.io.Serializable
import java.lang.annotation.ElementType


data class Bear  (
        @JsonProperty("name")
        val name : String,
        @JsonProperty("weight")
        val weight: String,
        @JsonProperty("color")
        val color: String,
        @JsonProperty("id")
        val id: String
        ) : Serializable

