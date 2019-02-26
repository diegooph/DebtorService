package com.debtorService.DebtorService.entity

import com.debtorService.DebtorService.dto.GeolocationDTO

class AddressDTO {
    lateinit var street: String
    lateinit var suite: String
    lateinit var city: String
    lateinit var zipcode: String
    lateinit var geo: GeolocationDTO
}