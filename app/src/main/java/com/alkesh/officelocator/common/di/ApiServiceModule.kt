package com.alkesh.officelocator.common.di

import com.alkesh.officelocator.dataProvider.network.retrofitService.RetrofitService
import com.alkesh.officelocator.dataProvider.network.services.OfficeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Provides
    fun provideGameResultApiService(retrofitService: RetrofitService): OfficeService {
        return retrofitService.getInstance(OfficeService::class.java)
    }
}