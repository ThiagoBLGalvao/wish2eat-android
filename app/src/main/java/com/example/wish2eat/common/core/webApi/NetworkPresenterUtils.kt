package com.example.wish2eat.common.core.webApi

import android.util.Log
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.exception.ErrorValidations
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
                if (error is HttpException) {
                    val apiError = Gson().fromJson(
                        error.response()?.errorBody()?.string(),
                        StandardError::class.java
                    )

                    handleError(apiError, callback)
                } else {
                    print(error.toString())
                    callback.invoke(error.toString())
                }
            }
    }

    private fun handleError(standardError: StandardError, callback: (text: String) -> Unit) {
        when (standardError.status) {
            422 -> handleError422(standardError.errorValidation!!, callback)
            else -> callback.invoke(standardError.message)
        }
    }

    private fun handleError422(
        errorsArray: Array<ErrorValidations>,
        callback: (text: String) -> Unit
    ) {
        var message = ""
        errorsArray.map {
            message += "The field:${it.fieldName +" "+ it.message}\n"
        }
        callback.invoke(message)
    }
}