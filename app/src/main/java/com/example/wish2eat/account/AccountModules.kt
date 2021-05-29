package com.example.wish2eat.account

import android.content.Context
import com.example.wish2eat.common.core.localApi.LocalApiAccount
import com.example.wish2eat.common.core.localApi.LocalApiAccountContract
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccount
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract
import com.example.wish2eat.account.presentaion.login.LoginContract
import com.example.wish2eat.account.presentaion.login.LoginPresenter
import com.example.wish2eat.account.presentaion.register.RegisterContract
import com.example.wish2eat.account.presentaion.register.RegisterPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object AccountModules {
    val instance = module {
        single {
            androidContext().getSharedPreferences(
                LocalApiAccount.ACCOUNT_FILE,
                Context.MODE_PRIVATE
            )
        }

        single<LocalApiAccountContract>{ LocalApiAccount(prefs = get()) }

        single<LocalRepositoryAccountContract>{ LocalRepositoryAccount(localApi = get()) }

        factory<LoginContract.Presenter> { (view: LoginContract.View)-> LoginPresenter( view = view, repository = get() ) }

        factory<RegisterContract.Presenter> { (view: RegisterContract.View) -> RegisterPresenter(view = view, repository = get()) }
    }
}