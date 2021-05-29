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
        const val USER_EMAIL = "user_email"

        fun newInstance(email: String) = ProfileFragment().apply {
            arguments = Bundle().apply{
                putString(USER_EMAIL, email)
            }
        }
    }

    private fun getEmail() = arguments?.getString(USER_EMAIL).orEmpty()

    override fun initFragment(rootView: View) {
        presenter.init(getEmail())

        accountEditButton?.setOnClickListener { presenter.onEditButtonClicked() }
    }

    override fun bind(user: UserModel) {
        user.apply {
            accountNameInput?.setText(name)
            accountEmailInput?.setText(email)

            if(profilePhoto != 0L)
                changeProfilePhoto(profilePhoto)
        }
    }

    override fun changeButtonText() {

    }

    override fun changeInputVisibility() {
    }

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    private fun showToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun changeProfilePhoto(profilePhoto: Long){

    }

    private fun verifyChanges(user: UserModel): Boolean {
        return user.run {
            email != accountEmailInput.text.toString() || name != accountNameInput?.text.toString()
        }
    }
}