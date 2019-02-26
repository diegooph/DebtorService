package com.debtorService.DebtorService.dto

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class DebtorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idDebtor: Long = 0
    var idUser: Long = 0
    var username: String = ""
    var description: String = ""
    lateinit var date: Date
    var totalValue: Double = 0.0
}
