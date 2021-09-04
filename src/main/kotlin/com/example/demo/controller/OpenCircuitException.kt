package com.example.demo.controller

import io.github.resilience4j.circuitbreaker.CallNotPermittedException

data class OpenCircuitException (val message: String, val exception : CallNotPermittedException)