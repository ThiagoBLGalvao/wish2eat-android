package com.example.wish2eat.common.core.localApi

import android.content.SharedPreferences
import com.example.wish2eat.common.core.model.UserModel
import com.google.gson.Gson

interface LocalApiAccountContract {
    fun save(user: UserModel)

    fun load(email: String): UserModel?

    fun loadLoginState(): Boolean

    fun changeLoginState(state: Boolean)
}

class LocalApiAccount(private val prefs: SharedPreferences, private val gson: Gson = Gson()):
    LocalApiAccountContract {
    companion object{
        const val ACCOUNT_FILE = "account_file"
        const val LOGIN_STATE = "login_state"
    }

    override fun save(user: UserModel) {
        val json = gson.toJson(user)

        prefs.edit().putString(user.email, json).apply()
    }

    override fun load(email: String): UserModel? {
        val json = prefs.getString(email, "")

        return gson.fromJson(json, UserModel::class.java)
    }

    override fun loadLoginState() = prefs.getBoolean(LOGIN_STATE, false)

    override fun changeLoginState(state: Boolean) {
        prefs.edit().putBoolean(LOGIN_STATE, state).apply()
    }
}