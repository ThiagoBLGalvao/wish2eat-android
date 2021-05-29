package com.example.wish2eat.account.presentaion.register

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RegisterFragment : BaseFragment(), RegisterContract.View {
    override val layoutResource: Int = R.layout.fragment_register

    private val presenter: RegisterContract.Presenter by inject { parametersOf(this) }

    companion object{ fun newInstance() = RegisterFragment() }

    override fun onResume() {
        super.onResume()
        buttonCreateAccountCard?.setOnClickListener { presenter.onRegisterAccountButtonClicked(createUser()) }
    }

    override fun initFragment(rootView: View) {}

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun createUser(): UserModel {
        val name: String  = nameInputCard?.text.toString()
        val email: String = emailInputCard?.text.toString()
        val password = passwordInputCard?.text.toString()

        return UserModel(name = name, email = email, password = password)
    }
}