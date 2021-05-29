package com.example.wish2eat.common.core.localApi

import com.example.wish2eat.common.core.model.UserModel

interface LocalRepositoryAccountContract {
    fun login(email: String, password: String): Boolean

    fun createAccount(account: UserModel)

    fun verifyLoginState(): Boolean

    fun loadAccount(email: String): UserModel
}

class LocalRepositoryAccount(private val localApi: LocalApiAccountContract) :
    LocalRepositoryAccountContract {
    override fun login(email: String, password: String): Boolean {
        val user = localApi.load(email)
        val loginResult = user?.password == password

        localApi.changeLoginState(loginResult)

        return loginResult
    }

    override fun createAccount(account: UserModel) {
        if(validateUser(account)){
            if (localApi.load(account.email) == null)
                localApi.save(account)
            else throw UserAlreadyExistException()
        }else throw InvalidAccountFields()
    }

    override fun verifyLoginState() = localApi.loadLoginState()

    override fun loadAccount(email: String) = localApi.load(email) ?: throw AccountNotExist()

    private fun validateUser(account: UserModel) =
        !(account.name.isEmpty() || account.password.isEmpty() || account.email.isEmpty())
}


class UserAlreadyExistException : Exception()
class InvalidAccountFields: Exception()
class AccountNotExist: Exception()