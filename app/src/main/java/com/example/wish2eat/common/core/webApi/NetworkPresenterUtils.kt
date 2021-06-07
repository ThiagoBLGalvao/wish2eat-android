package com.example.wish2eat.common.core.webApi

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
            .onErrorResumeNext { error: Throwable ->
                Observable.error<T>(error)
            }
//            .doOnError { error: Throwable -> error.message?.let{ callback.invoke(it) } }
    }
}