package com.alkesh.officelocator.presenter.screens.locations.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.officelocator.common.base.viewModel.BaseViewModel
import com.alkesh.officelocator.dataProvider.network.models.dto.OfficeLocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfficeDetailViewModel @Inject constructor() : BaseViewModel() {
    val liveDataOfficeLocationModel = MutableLiveData<OfficeLocationModel>()
    val readDataFromBundle = MutableLiveData<Boolean>()

    init {
        readDataFromBundle.value = true
    }

    fun setResults(officeLocationModel: OfficeLocationModel) {
        liveDataOfficeLocationModel.value = officeLocationModel
    }
}