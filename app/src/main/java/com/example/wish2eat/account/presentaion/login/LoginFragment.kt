package com.example.wish2eat.account.presentaion.login

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.account.presentaion.register.RegisterFragment
import com.example.wish2eat.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginFragment: BaseFragment(), LoginContract.View {
    private val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    companion object{
        fun newInstance() = LoginFragment()
    }

    override val layoutResource = R.layout.fragment_login

    fun getEmail() = emailLoginInput?.text.toString()

    fun getPassword() = passwordLoginInput?.text.toString()

    override fun initFragment(rootView: View) {
        buttonLoginFragment?.setOnClickListener { presenter.onLoginPressed(getEmail(), getPassword()) }

        buttonCreateAccountLoginFragment?.setOnClickListener { presenter.onCreateAccountPressed() }
    }

    override fun openRegisterFragment() {
        val fragment = RegisterFragment.newInstance()

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container_fragment, fragment)
            ?.addToBackStack("fragment_register")
            ?.commit()
    }

    override fun openDashboard() {}

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    private fun showToast(message: String){
        Toast.makeText(requireContext(), message,Toast.LENGTH_SHORT).show()
    }
}