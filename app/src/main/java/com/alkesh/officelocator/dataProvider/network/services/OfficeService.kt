package com.alkesh.officelocator.dataProvider.network.services

import com.alkesh.officelocator.dataProvider.network.models.response.GetOfficeLocationsApiResponse
import retrofit2.Response
import retrofit2.http.GET


interface OfficeService {
    @GET("dev/DewaLocations.json")
    suspend fun getOfficeLocations(): Response<GetOfficeLocationsApiResponse>

}