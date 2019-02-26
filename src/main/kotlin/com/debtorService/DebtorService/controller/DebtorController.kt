package com.debtorService.DebtorService.controller

import com.debtorService.DebtorService.dao.DebtorRepository
import com.debtorService.DebtorService.dto.DebtorDTO
import com.debtorService.DebtorService.worker.DebtorWorker
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RestController
@RequestMapping("/debtor")
@EnableWebMvc
@CrossOrigin
class DebtorController(val debtorRepository: DebtorRepository) {
    @GetMapping("/all")
    fun getAll() = DebtorWorker(debtorRepository).getAll()

    @GetMapping("/usersdebtor")
    fun getUsersDebtor() = DebtorWorker(debtorRepository).getUsersDebtor()

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long) = DebtorWorker(debtorRepository).getOne(id)

    @PostMapping("/new")
    fun new(@RequestBody debtorDTO: DebtorDTO) = DebtorWorker(debtorRepository).save(debtorDTO)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = DebtorWorker(debtorRepository).delete(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody debtorDTO: DebtorDTO): DebtorDTO = DebtorWorker(debtorRepository).update(id, debtorDTO)

}