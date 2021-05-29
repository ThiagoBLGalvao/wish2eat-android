package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.common.core.vo.UserVO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Wish2EatApi {
    @GET("users/{id}")
    fun getUser(@Path("id") id: String): Observable<UserVO>
}