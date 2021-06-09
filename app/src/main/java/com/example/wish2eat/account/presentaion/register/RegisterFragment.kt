package com.example.wish2eat.account.presentaion.register

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.vo.UserVO
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RegisterFragment : BaseFragment(), RegisterContract.View {
    override val layoutResource: Int = R.layout.fragment_register

    private val presenter: RegisterContract.Presenter by inject { parametersOf(this) }

    companion object {
        const val NAME = "Register_Fragment"

        fun newInstance() = RegisterFragment()
    }

    override fun onResume() {
        super.onResume()
        buttonCreateAccountCard?.setOnClickListener {
            if (nameInputCard.text.isNullOrBlank() || emailInputCard.text.isNullOrBlank() || passwordInputCard.text.isNullOrBlank())
                showToast(getString(R.string.not_empty_field))
            else
                presenter.onRegisterAccountButtonClicked(createUser())
        }
    }

    override fun initFragment(rootView: View) {}

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoader() {
        basicLoader.changeVisibility(true)
    }

    override fun hideLoader() {
        basicLoader.changeVisibility(false)
    }

    private fun createUser() = UserVO(
        name = nameInputCard.text.toString(),
        email = emailInputCard.text.toString(),
        password = passwordInputCard.text.toString()
    )
}