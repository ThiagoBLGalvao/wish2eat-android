package com.example.wish2eat.home.presentation.account

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.model.UserModel
import kotlinx.android.synthetic.main.fragment_account.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ProfileFragment: BaseFragment(), ProfileContract.View{

    override val layoutResource: Int = R.layout.fragment_account

    private val presenter: ProfileContract.Presenter by inject { parametersOf(this) }

    companion object{
        const val USER_ID = "user_id"

        fun newInstance(id: Long) = ProfileFragment().apply {
            arguments = Bundle().apply{
                putLong(USER_ID, id)
            }
        }
    }

    private fun getUserId() = arguments?.getLong(USER_ID)!!

    override fun initFragment(rootView: View) {
        presenter.init(getUserId())

        accountEditButton?.setOnClickListener {
            if(!verifyFields())
                presenter.onEditButtonClicked(getUser())
            else showToast(getString(R.string.not_empty))
        }
    }

    override fun bind(user: UserModel) {
        user.apply {
            accountNameInput?.setText(name)
            accountEmailInput?.setText(email)
        }
    }

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoader() {
        basicLoader.changeVisibility(true)
    }

    override fun hideLoader() {
        basicLoader.changeVisibility(false)
    }

    private fun verifyFields():  Boolean{
        return accountEmailInput.text.isNullOrBlank() || accountNameInput.text.isNullOrBlank() ||accountPasswordInput.text.isNullOrBlank()
    }

    private fun getUser() =
        UserModel(
            name = accountNameInput.text.toString(),
            email = accountEmailInput.text.toString(),
            password = accountPasswordInput.text.toString()
        )
}