package com.example.wish2eat.common.customViews.dialogUserMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.wish2eat.R
import com.example.wish2eat.common.NavigationDialog
import com.example.wish2eat.home.presentation.account.ProfileFragment
import com.example.wish2eat.home.presentation.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.dialog_account_fragment.*

class DialogUserMenu : DialogFragment() {
    private lateinit var listener: NavigationDialog
    private lateinit var fragmentThis: Fragment

    companion object {
        fun newInstance() = DialogUserMenu()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_account_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAccountButton?.setOnClickListener {
            listener.toAccount()
            this.dismiss()
        }

        myFavoriteListButton?.setOnClickListener {
            listener.toMyFavoriteList()
            this.dismiss()
        }


        if(fragmentThis is DashboardFragment)
            hideMyFavoriteListButton()
        else
            showMyFavoriteListButton()

        if (fragmentThis is ProfileFragment)
            hideAccountButton()
        else showAccountButton()

        logoutButton.setOnClickListener { listener.logout() }
    }

    override fun onStart() {
        super.onStart()

        val width = (resources.displayMetrics.widthPixels * 0.8).toInt()

        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun showMyFavoriteListButton(){
    }
    fun hideMyFavoriteListButton(){
        myFavoriteListButton.visibility = View.GONE
    }
    fun showAccountButton(){
        myAccountButton.visibility = View.VISIBLE
    }
    fun hideAccountButton(){
        myAccountButton.visibility = View.GONE
    }

    fun setFragment(fragment: Fragment){
        fragmentThis = fragment
    }

    fun setListener(listenerNavigation: NavigationDialog){
        listener = listenerNavigation
    }
}