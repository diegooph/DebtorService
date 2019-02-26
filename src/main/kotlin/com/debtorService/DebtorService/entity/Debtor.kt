package com.debtorService.DebtorService.entity

import com.debtorService.DebtorService.dto.DebtorDTO
import com.debtorService.DebtorService.dto.UserDTO
import com.debtorService.DebtorService.worker.UserWorker
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity

class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idDebtor: Long = 0
    @Transient
    var user: UserDTO?
    var idUser: Long = 0
    var description: String = ""
    var date: Date
    var totalValue: Double = 0.0

    constructor(debtorDTO: DebtorDTO) {
        this.user = UserWorker().getAll()!!.find { userDTO -> userDTO.id == debtorDTO.idUser }
        this.idDebtor = debtorDTO.idDebtor
        this.description = debtorDTO.description
        this.date = debtorDTO.date
        this.totalValue = debtorDTO.totalValue
        this.idUser = debtorDTO.idUser
    }

    fun toDto(debtor: Debtor): DebtorDTO {
        var debtorDTO = DebtorDTO()
        var userDTO = UserWorker().getAll()?.find { userDTO -> userDTO.id == debtor.idUser }
        debtorDTO.idDebtor = this.idDebtor
        debtorDTO.username = userDTO?.name ?: ""
        debtorDTO.idUser = userDTO?.id ?: 0
        debtorDTO.description = this.description
        debtorDTO.date = this.date
        debtorDTO.totalValue = this.totalValue
        return debtorDTO
    }

    companion object {
        fun toDtoList(debtors: List<Debtor>): List<DebtorDTO> {

            var listDebtorDTO: List<DebtorDTO> = listOf()
            var userDTO: UserDTO?

            debtors.forEach { debtor ->
                userDTO = UserWorker().getAll()?.find { userDTO -> userDTO.id == debtor.idUser }
                var debtorDTO = DebtorDTO()
                debtorDTO.idDebtor = debtor.idDebtor
                debtorDTO.username = userDTO?.name ?: ""
                debtorDTO.idUser = userDTO?.id ?: 0
                debtorDTO.description = debtor.description
                debtorDTO.date = debtor.date
                debtorDTO.totalValue = debtor.totalValue
                listDebtorDTO = listDebtorDTO + debtorDTO
            }

            return listDebtorDTO
        }
    }
}
