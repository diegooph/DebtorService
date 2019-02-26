package br.com.alexf.ceep.retrofit.service

import com.debtorService.DebtorService.dto.UserDTO
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("users/")
    fun list(): Call<List<UserDTO>>
}