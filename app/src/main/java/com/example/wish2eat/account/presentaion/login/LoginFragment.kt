package com.example.wish2eat.account.presentaion.login

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.account.presentaion.register.RegisterFragment
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.model.UserModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginFragment: BaseFragment(), LoginContract.View {
    private val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    private var login:((userModel: UserModel)->Unit)? = null

    companion object{
        fun newInstance(loginCallback:(userModel: UserModel)->Unit) = LoginFragment().apply {
            login = loginCallback
        }
    }

    override val layoutResource = R.layout.fragment_login

    private fun getEmail() = emailLoginInput?.text.toString()

    private fun getPassword() = passwordLoginInput?.text.toString()

    override fun initFragment(rootView: View) {
        buttonLoginFragment?.setOnClickListener { presenter.onLoginPressed(getEmail(), getPassword()) }

        buttonCreateAccountLoginFragment?.setOnClickListener { presenter.onCreateAccountPressed() }
    }

    override fun openRegisterFragment() {
        val fragment = RegisterFragment.newInstance()

        targetingManager.replace(fragment, RegisterFragment.NAME)
    }

    override fun loginUser(userModel: UserModel) {
        login?.invoke(userModel)
    }

    override fun openDashboard(userModel: UserModel) { loginUser(userModel) }

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String){
        Toast.makeText(requireContext(), message,Toast.LENGTH_SHORT).show()
    }
}