package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.common.core.model.LoginModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.vo.FavoriteProduct
import com.example.wish2eat.common.core.vo.FavoriteStore
import com.example.wish2eat.common.core.vo.UserVO
import io.reactivex.Observable

interface WebRepositoryContract {
    fun getUser(id: Long): Observable<UserModel>

    fun createUser(vo: UserVO): Observable<UserVO>

    fun login(vo: LoginModel): Observable<UserModel>

    fun update(id: Long, vo: UserVO): Observable<UserModel>

    fun getAllStores(): Observable<List<StoreModel>>

    fun getStore(id: Long): Observable<StoreModel>

    fun createFavStore(favoriteStore: FavoriteStore): Observable<String>

    fun createFavProduct(favoriteProduct: FavoriteProduct):Observable<String>
}