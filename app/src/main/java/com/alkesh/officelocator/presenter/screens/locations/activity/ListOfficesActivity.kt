package com.alkesh.officelocator.presenter.screens.locations.activity

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkesh.officelocator.R
import com.alkesh.officelocator.common.base.activity.AppBaseActivity
import com.alkesh.officelocator.dataProvider.network.models.dto.OfficeLocationModel
import com.alkesh.officelocator.databinding.ActivityListOfficesBinding
import com.alkesh.officelocator.presenter.screens.locations.adapter.ListOfficeAdapter
import com.alkesh.officelocator.presenter.screens.locations.constant.OfficeDetailConstant
import com.alkesh.officelocator.presenter.screens.locations.listener.OnOfficeClicked
import com.alkesh.officelocator.presenter.screens.locations.viewModel.ListOfficeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list_offices.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class ListOfficesActivity : AppBaseActivity<ActivityListOfficesBinding>() {
    private val viewModel: ListOfficeViewModel by viewModels()
    override fun init() {
        toolbar.setup(this, getString(R.string.activity_list_offices_title), false)

    }

    override fun setEvents() {
        swipeRefresh.setOnRefreshListener {
            viewModel.getData()
        }
    }

    override fun setObservers() {
        viewModel.locationAppModel.observe(this, Observer {
            it?.coordinateModel?.item?.let {
                if (it.isNotEmpty()) {
                    populateList(it)
                }
            }
        })
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
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_list_offices
    }

    private fun populateList(list: ArrayList<OfficeLocationModel>) {
        val adapter = ListOfficeAdapter(this, list, onResultSelected)
        bindVerticalAdapterWithRecyclerview(recyclerView, adapter)
    }

    private val onResultSelected = object : OnOfficeClicked {
        override fun onClicked(uiGameResultModel: OfficeLocationModel) {
            val intent = Intent(this@ListOfficesActivity, OfficeDetailActivity::class.java)
            intent.putExtra(OfficeDetailConstant.Bundle_Office_Model, uiGameResultModel)
            startAnotherActivity(intent)
        }
    }

    override fun dataBinding(dataBinder: ActivityListOfficesBinding) {

    }
}