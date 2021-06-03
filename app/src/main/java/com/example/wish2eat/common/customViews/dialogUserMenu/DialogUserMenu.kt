package com.example.wish2eat.common.customViews.dialogUserMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.wish2eat.R
import com.example.wish2eat.common.NavigationDialog
import kotlinx.android.synthetic.main.dialog_account_fragment.*

class DialogUserMenu : DialogFragment() {
    private lateinit var listener: NavigationDialog

    companion object {
        fun newInstance(
            listenerNavigation: NavigationDialog
        ) = DialogUserMenu().apply {
            listener = listenerNavigation
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myAccountButton?.setOnClickListener { listener.toAccount() }

        myFavoriteListButton?.setOnClickListener { listener.toMyFavoriteList() }

        return inflater.inflate(R.layout.dialog_account_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()

        val width = (resources.displayMetrics.widthPixels * 0.8).toInt()

        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}