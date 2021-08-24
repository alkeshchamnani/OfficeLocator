package com.alkesh.officelocator.dataProvider.network.exception

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String?
        get() = "No Internet Connection"

}