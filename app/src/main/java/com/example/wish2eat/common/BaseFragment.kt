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
//        val fragment =
    }

    override fun toMyFavoriteList() {
//        TODO("Not yet implemented")
    }

    private fun implementationToolbar(){
        basicToolbarComponent.apply {
            setAccountButtonBehavior { openAccountDialog() }
            setBackButtonBehavior {  }
        }
    }

    fun turnBackFlow(){
        baseActivity.onBackPressed()
    }

    protected fun showBasicToolbarBackButton(){
        basicToolbarComponent.changeVisibilityBackButton(true)
    }
    protected fun hideBasicToolbarBackButton(){
        basicToolbarComponent.changeVisibilityBackButton(false)
    }

    private fun openAccountDialog(){
        DialogUserMenu.newInstance(this@BaseFragment).show(baseActivity.supportFragmentManager, "DialogAccountNavigationMenu")
    }
}