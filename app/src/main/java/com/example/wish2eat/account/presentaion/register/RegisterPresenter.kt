package com.example.wish2eat.account.presentaion.register

import com.example.wish2eat.R
import com.example.wish2eat.common.core.localApi.InvalidAccountFields
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract
import com.example.wish2eat.common.core.localApi.UserAlreadyExistException
import com.example.wish2eat.common.core.model.UserModel

class RegisterPresenter(
    private val view: RegisterContract.View?,
    private val repository: LocalRepositoryAccountContract
) : RegisterContract.Presenter {
    override fun onRegisterAccountButtonClicked(user: UserModel) {
        try {
            repository.createAccount(user)

            view?.showToast(R.string.user_created)
        } catch (e: UserAlreadyExistException) {
            view?.showToast(R.string.user_already_exist)
        }catch (e: InvalidAccountFields){
            view?.showToast(R.string.user_fields_invalid)
        }
    }
}