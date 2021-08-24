package com.alkesh.officelocator.presenter.screens.splash.activity

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.officelocator.R
import com.alkesh.officelocator.common.base.activity.AppBaseActivity
import com.alkesh.officelocator.databinding.ActivitySplashBinding
import com.alkesh.officelocator.presenter.screens.locations.activity.ListOfficesActivity
import com.alkesh.officelocator.presenter.screens.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppBaseActivity<ActivitySplashBinding>() {
    private val viewModel: SplashViewModel by viewModels()
    override fun init() {

    }

    override fun setEvents() {
    }

    override fun setObservers() {
        viewModel.navigateListOfficeLocations.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, ListOfficesActivity::class.java))
                finish()
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_splash
    override fun dataBinding(dataBinder: ActivitySplashBinding) {

    }
}