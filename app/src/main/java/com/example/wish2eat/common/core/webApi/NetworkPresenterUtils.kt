package com.example.wish2eat.common.core.webApi

import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.exception.StandardError
import com.google.gson.Gson
import io.reactivex.Observable
import org.koin.dsl.koinApplication
import retrofit2.HttpException

interface NetworkPresenterUtils {

    fun <T> request(
        observable: Observable<T>,
        callback: (text: String) -> Unit
    ): Observable<T> {
        return observable
            .compose(NetworkUtils.offerObservableThreads())
            .doOnError { error: Throwable ->
                if(error is HttpException){
                    val apiError = Gson().fromJson(error.response()?.errorBody()?.string(), StandardError::class.java)

                    handleError(apiError, callback)
                }else{ callback.invoke(error.toString()) }
            }
    }

    fun handleError(standardError: StandardError, callback: (text: String) -> Unit){
        when(standardError.status){
            422 -> callback.invoke("This User Already Exist")
            else -> callback.invoke(standardError.message)
        }
    }
}