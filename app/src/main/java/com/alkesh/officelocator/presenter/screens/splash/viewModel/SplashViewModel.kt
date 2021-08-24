package com.alkesh.officelocator.presenter.screens.splash.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.alkesh.officelocator.common.base.viewModel.BaseViewModel
import com.alkesh.officelocator.presenter.screens.splash.constant.SplashConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor() :
    BaseViewModel() {
    val navigateListOfficeLocations = MutableLiveData<Boolean>()

    init {
        splashDelayed()
    }

    private fun splashDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateListOfficeLocations.value = true
        }, SplashConstant.splashDuration)
    }

}