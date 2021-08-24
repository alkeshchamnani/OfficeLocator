package com.alkesh.officelocator.presenter.screens.locations.listener

import com.alkesh.officelocator.dataProvider.network.models.dto.OfficeLocationModel


interface OnOfficeClicked {
    fun onClicked(uiGameResultModel: OfficeLocationModel)
}