package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.vo.toModel
import io.reactivex.Observable

class WebRepository(private val wish2EatApi: Wish2EatApi) : WebRepositoryContract {
    override fun getUser(id: String): Observable<UserModel> {
        return wish2EatApi
                .getUser(id)
                .map{ it.toModel() }
    }
}