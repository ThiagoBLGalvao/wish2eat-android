package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.common.core.model.LoginModel
import com.example.wish2eat.common.core.vo.FavoriteProduct
import com.example.wish2eat.common.core.vo.FavoriteStore
import com.example.wish2eat.common.core.vo.ListOfStoresVO
import com.example.wish2eat.common.core.vo.UserVO
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Wish2EatApi {
    @GET("users/{id}")
    fun getUser(@Path("id") id: String): Observable<UserVO>

    @POST("users/login")
    fun loginUser(vo: LoginModel): Observable<UserVO>

    @GET("store")
    fun getAllStores(): Observable<ListOfStoresVO>

    @POST
    fun createUser(@Body userVO: UserVO): Observable<UserVO>

    @POST("favorite")
    fun createFavorite(@Body favoriteProduct: FavoriteProduct): Observable<String>

    @POST("favStore")
    fun createFavoriteStore(@Body favoriteStore: FavoriteStore)
}