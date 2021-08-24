package com.alkesh.officelocator.common.repository

import com.alkesh.officelocator.common.base.repository.BaseRepository
import com.alkesh.officelocator.dataProvider.network.models.response.GetOfficeLocationsApiResponse
import com.alkesh.officelocator.dataProvider.network.services.OfficeService
import javax.inject.Inject


open class OfficeRepository @Inject constructor(
    private val officeService: OfficeService
) : BaseRepository() {


    suspend fun getOffices(): GetOfficeLocationsApiResponse? {
        var model: GetOfficeLocationsApiResponse? = null
        try {
            val response = officeService.getOfficeLocations()
            if (response.isSuccessful) {
                model = response.body()
                model?.let {
                    it.successful = true
                }
            }
        } catch (exp: Exception) {
            model = GetOfficeLocationsApiResponse()
            model.let {
                it.successful = false
                it.message = exp.message
            }

        }
        return model
    }
}