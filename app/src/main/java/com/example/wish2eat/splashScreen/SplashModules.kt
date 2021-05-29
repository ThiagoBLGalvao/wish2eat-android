package com.example.wish2eat.splashScreen

import com.example.wish2eat.common.core.webApi.NetworkUtils
import com.example.wish2eat.common.core.webApi.WebRepository
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import com.example.wish2eat.common.core.webApi.Wish2EatApi
import org.koin.dsl.module

object SplashModules {
    val instance = module {
        single<WebRepositoryContract> {
            WebRepository(
                NetworkUtils
                    .getWishToEatApi("https://wish2eat-dev.herokuapp.com:443/")
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