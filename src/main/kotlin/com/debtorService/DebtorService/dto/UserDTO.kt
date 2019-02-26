package com.debtorService.DebtorService.dto
import com.debtorService.DebtorService.entity.AddressDTO
import com.debtorService.DebtorService.entity.CompanyDTO


class UserDTO {
  
    var id: Long = 0
    lateinit var name: String
    lateinit var username: String
    lateinit var email: String
    lateinit var phone: String
    lateinit var website: String
    lateinit var address: AddressDTO
    lateinit var company: CompanyDTO
}
