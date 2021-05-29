package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.common.core.model.UserModel
import io.reactivex.Observable

interface WebRepositoryContract {
    fun getUser(id: String): Observable<UserModel>
}