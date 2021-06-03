package com.example.wish2eat.common.core.webApi

import io.reactivex.Observable

interface NetworkPresenterUtils {

        fun <T> request(
            observable: Observable<T>,
            callback: (text: String) -> Unit
        ): Observable<T> {
            return observable
                .compose(NetworkUtils.offerObservableThreads())
                .onErrorResumeNext { error: Throwable ->
                    errorToString(error, callback)
                    Observable.error<T>(error)
                }
        }

        private fun errorToString(err: Throwable, callback: (text: String) -> Unit) {
            callback(err.toString())
        }
}