package com.example.demo.out.client

import com.fasterxml.jackson.annotation.JsonProperty

data class Bear (
        @JsonProperty("name")
        val name : String,
        @JsonProperty("weight")
        val weight: String,
        @JsonProperty("color")
        val color: String,
        @JsonProperty("id")
        val id: String
        )