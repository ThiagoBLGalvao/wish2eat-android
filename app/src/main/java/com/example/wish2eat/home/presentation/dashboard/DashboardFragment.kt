package com.example.wish2eat.home.presentation.dashboard

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseFragment(), DashboardContract.View {
    override val layoutResource: Int = R.layout.fragment_dashboard

    override fun initFragment(rootView: View) {

    }

    override fun init() {
        TODO("Not yet implemented")
    }

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
}