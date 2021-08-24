package com.alkesh.officelocator.presenter.screens.locations.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.officelocator.common.base.viewModel.BaseViewModel
import com.alkesh.officelocator.common.repository.OfficeRepository
import com.alkesh.officelocator.dataProvider.network.models.dto.LocationsAppModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfficeViewModel @Inject constructor(private val officeRepository: OfficeRepository) :
    BaseViewModel() {
    val locationAppModel = MutableLiveData<LocationsAppModel>()

    init {
        getData()
    }

    fun getOfficeLocations() {
        isLoading.value = true
        showMessage.value = null
        coroutineScope.launch {
            val result = officeRepository.getOffices()
            isLoading.value = false
            result?.let {
                if (it.successful) {
                    locationAppModel.value = result.locationsAppModel
                } else {
                    showMessage.value = result.message
                }
            }
        }
    }

    fun getData() {
        getOfficeLocations()
    }
}