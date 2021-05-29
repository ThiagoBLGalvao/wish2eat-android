package com.example.wish2eat.home.presentation.account

import com.example.wish2eat.R
import com.example.wish2eat.common.core.localApi.AccountNotExist
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract
import com.example.wish2eat.common.core.model.UserModel

class ProfilePresenter(
    private val view: ProfileContract.View,
    private val repository: LocalRepositoryAccountContract
    ) : ProfileContract.Presenter {
    override fun init(email: String) {
        try {
            val user = repository.loadAccount(email)

            view.bind(user)
        } catch (e: AccountNotExist) {
            view.showToast(R.string.account_not_exist)
        }
    }

    override fun onEditButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun updateAccount(user: UserModel) {
        TODO("Not yet implemented")
    }
}