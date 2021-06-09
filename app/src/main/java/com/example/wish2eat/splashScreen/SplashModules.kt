package com.example.wish2eat.splashScreen

import com.example.wish2eat.common.core.webApi.NetworkUtils
import com.example.wish2eat.common.core.webApi.WebRepository
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import com.example.wish2eat.common.core.webApi.Wish2EatApi
import org.koin.dsl.module

object SplashModules {
    val localApi = "http://10.0.2.2:8080/"
    val api = "https://wish2eat-dev.herokuapp.com/"

    val instance = module {
        single<WebRepositoryContract> {
            WebRepository(
                NetworkUtils
                    .getWishToEatApi(api)
                    .create(Wish2EatApi::class.java)
            )
        }

        factory<SplashContract.Presenter> { (view: SplashContract.View) ->
            SplashPresenter(
                view = view,
                repository = get()
            )
        }
    }
}