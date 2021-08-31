package com.example.demo.controller

import com.example.demo.out.client.Bear
import com.example.demo.service.BearService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bears")
class BearController (val bearService: BearService) {

    @GetMapping()
   fun getBears(): Bear {

       return bearService.getBears()

   }

}