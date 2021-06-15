package com.example.wish2eat.common.customViews.dialogUserMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.wish2eat.R
import com.example.wish2eat.common.NavigationDialog
import kotlinx.android.synthetic.main.dialog_account_fragment.*

class DialogUserMenu : DialogFragment() {
    private lateinit var listener: NavigationDialog

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
    }

    override fun onStart() {
        super.onStart()

        val width = (resources.displayMetrics.widthPixels * 0.8).toInt()

        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setListener(listenerNavigation: NavigationDialog){
        listener = listenerNavigation
    }
}