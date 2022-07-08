package com.chenyh.ktdemo.controller

import com.chenyh.ktdemo.mode.User
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/")
class IndexController(
    @Autowired
    var restTemplate: RestTemplate
) {


    @RequestMapping("/")
    fun index(): String {
        val objectMapper = ObjectMapper().registerModule(KotlinModule())
        val user = User("Bob", 123)
        return objectMapper.writeValueAsString(user)
    }

    @RequestMapping("Google")
    fun curl(): String? {
        val forEntity = restTemplate.getForEntity("https://www.google.com", String::class.java)
        return forEntity.body
    }
}

