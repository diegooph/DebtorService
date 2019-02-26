package com.debtorService.DebtorService.worker

import br.com.alexf.ceep.retrofit.service.UserService
import com.debtorService.DebtorService.dto.UserDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserWorker {
    
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getAll(): List<UserDTO>? = retrofit.create(UserService::class.java).list().execute().body()
}