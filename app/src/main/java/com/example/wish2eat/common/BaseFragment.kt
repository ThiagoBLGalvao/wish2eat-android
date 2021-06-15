package com.example.wish2eat.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wish2eat.common.core.targeting.TargetingManager
import com.example.wish2eat.common.customViews.basicToolbar.BasicToolbarComponentContract
import com.example.wish2eat.common.customViews.dialogUserMenu.DialogUserMenu
import com.example.wish2eat.common.customViews.loader.LoaderContract
import com.example.wish2eat.home.HomeActivity
import com.example.wish2eat.home.presentation.account.ProfileFragment
import com.example.wish2eat.home.presentation.dashboard.DashboardFragment

abstract class BaseFragment: Fragment(), NavigationDialog {
    protected abstract val layoutResource: Int

    private val baseActivity: BaseActivity
        get() = activity as BaseActivity

    private val basicToolbarComponent: BasicToolbarComponentContract
        get() = (activity as BaseActivity).basicToolbarComponent

    val basicLoader: LoaderContract
        get() = (activity as BaseActivity).basicLoader

    val targetingManager: TargetingManager
        get() = (activity as BaseActivity).targetingManager

    abstract fun initFragment(rootView: View)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFragment(view)

        implementationToolbar()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutResourceId = layoutResource

        return if(layoutResourceId == 0){
            super.onCreateView(inflater, container, savedInstanceState)
        } else{
            inflater.inflate(layoutResourceId, container, false)
        }
    }

    override fun toAccount() {
        if (baseActivity is HomeActivity){
            val fragment = ProfileFragment.newInstance((baseActivity as HomeActivity).getEntity().id)

            targetingManager.replace(fragment, "profile_fragment")
        }
    }

    override fun toMyFavoriteList() {
        if (baseActivity is HomeActivity){
            val fragment = DashboardFragment.newInstance((baseActivity as HomeActivity).getEntity())

            targetingManager.replace(fragment, "dashboard_fragment")
        }
    }

    private fun implementationToolbar(){
        basicToolbarComponent.apply {
            setAccountButtonBehavior { openAccountDialog() }
            setBackButtonBehavior { turnBackFlow() }
        }
    }

    private fun turnBackFlow(){
        baseActivity.onBackPressed()
    }

    protected fun showBasicToolbarBackButton(){
        basicToolbarComponent.changeVisibilityBackButton(true)
    }
    protected fun hideBasicToolbarBackButton(){
        basicToolbarComponent.changeVisibilityBackButton(false)
    }

    private fun openAccountDialog(){
        DialogUserMenu.newInstance().apply {
            setListener(this@BaseFragment)

            show(baseActivity.supportFragmentManager, "DialogAccountNavigationMenu")
        }
    }
}