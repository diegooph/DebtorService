package com.debtorService.DebtorService.controller


import com.debtorService.DebtorService.dto.UserDTO
import com.debtorService.DebtorService.worker.UserWorker
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
@CrossOrigin
@RequestMapping(value = "/user")
class UserController {

    @GetMapping("/all")
    fun getAll(): List<UserDTO>? = UserWorker().getAll()

}