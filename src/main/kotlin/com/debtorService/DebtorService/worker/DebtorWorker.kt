package com.debtorService.DebtorService.worker

import com.debtorService.DebtorService.dao.DebtorRepository
import com.debtorService.DebtorService.dto.DebtorDTO
import com.debtorService.DebtorService.dto.UserDTO
import com.debtorService.DebtorService.entity.Debtor
import java.util.*

class DebtorWorker(private val debtorRepository: DebtorRepository) {

    fun save(debtorDTO: DebtorDTO): Debtor = debtorRepository.save(Debtor(debtorDTO))

    fun getAll(): List<DebtorDTO> = Debtor.toDtoList(debtorRepository.findAll())
    fun getUsersDebtor():List<UserDTO> {
        var listUserId = debtorRepository.findAll().map(Debtor::idUser).toList()
        return  UserWorker().getAll()?.filter { user -> listUserId.contains(user.id)}!!.toList()
    }

    fun getOne(id: Long): Optional<Debtor> = debtorRepository.findById(id)
    fun delete(id: Long) = debtorRepository.deleteById(id)
    fun update(id: Long, debtorDTO: DebtorDTO): DebtorDTO {
        val debtorUpdate: Debtor = debtorRepository.findById(id).orElseThrow { Exception("server error") }
        debtorUpdate.idDebtor = debtorDTO.idDebtor
        debtorUpdate.date = debtorDTO.date
        debtorUpdate.description = debtorDTO.description
        debtorUpdate.totalValue = debtorDTO.totalValue
        return debtorRepository.save(debtorUpdate).toDto(debtorUpdate)
    }
}