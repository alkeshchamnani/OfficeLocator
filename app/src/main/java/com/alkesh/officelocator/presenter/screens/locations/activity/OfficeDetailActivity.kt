package com.alkesh.officelocator.presenter.screens.locations.activity

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.officelocator.R
import com.alkesh.officelocator.common.base.activity.AppBaseActivity
import com.alkesh.officelocator.dataProvider.network.models.dto.OfficeLocationModel
import com.alkesh.officelocator.databinding.ActivityOfficeDetailBinding
import com.alkesh.officelocator.presenter.screens.locations.constant.OfficeDetailConstant
import com.alkesh.officelocator.presenter.screens.locations.viewModel.OfficeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list_offices.*
import kotlinx.android.synthetic.main.activity_office_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class OfficeDetailActivity : AppBaseActivity<ActivityOfficeDetailBinding>() {
    private val viewModel: OfficeDetailViewModel by viewModels()
    private lateinit var dataBinding: ActivityOfficeDetailBinding
    private var officeLocationModel: OfficeLocationModel? = null
    override fun init() {
        toolbar.setup(this, getString(R.string.activity_list_office_detail_title), false)

    }

    override fun setEvents() {
        tvTapMe.setOnClickListener(View.OnClickListener {
            officeLocationModel?.let {
                val lat = it.lat
                val lon = it.lon
                val string = lat + "," + lon
                val gmmIntentUri = Uri.parse("google.streetview:cbll={$string}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        })
    }

    override fun setObservers() {

        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    showLoadingDialog()
                    swipeRefresh.isRefreshing = true
                } else {
                    hideLoadingDialog()
                    swipeRefresh.isRefreshing = false
                }
            }
        })
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })
        viewModel.liveDataOfficeLocationModel.observe(this, Observer {
            it?.let {
                officeLocationModel = it
                populateGameResult(it)
            }
        })
        viewModel.readDataFromBundle.observe(this, Observer {
            if (it) {
                readDataFromBundle()
            }
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_office_detail
    }


    override fun dataBinding(dataBinder: ActivityOfficeDetailBinding) {
        dataBinding = dataBinder
    }

    private fun populateGameResult(officeLocationModel: OfficeLocationModel) {
        dataBinding.model = officeLocationModel

    }

    private fun readDataFromBundle() {
        val ob = intent.getSerializableExtra(OfficeDetailConstant.Bundle_Office_Model)
        if (ob is OfficeLocationModel) {
            viewModel.setResults(ob)
        }
    }
}