package com.example.wish2eat.common.core.webApi

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class NetworkUtils {
    companion object {
        val gson = GsonBuilder().setLenient().create()

        fun getWishToEatApi(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        @JvmStatic
        fun <T> offerObservableThreads(): ObservableTransformer<T, T> {
            return ObservableTransformer { observable: Observable<T> ->
                observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}