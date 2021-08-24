package com.alkesh.officelocator.presenter.screens.locations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alkesh.officelocator.R
import com.alkesh.officelocator.dataProvider.network.models.dto.OfficeLocationModel
import com.alkesh.officelocator.databinding.CellListOfficeBinding
import com.alkesh.officelocator.presenter.screens.locations.listener.OnOfficeClicked


class ListOfficeAdapter(
    private val context: Context,
    private val list: ArrayList<OfficeLocationModel>,
    private val onOfficeClicked: OnOfficeClicked
) : RecyclerView.Adapter<ListOfficeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CellListOfficeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cell_list_office, parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.bind(model, holder.itemView)
        holder.itemView.setOnClickListener(View.OnClickListener {
            onOfficeClicked.onClicked(model)
        })
    }

    class ViewHolder(private val cellListGameResultBinding: CellListOfficeBinding) :
        RecyclerView.ViewHolder(cellListGameResultBinding.getRoot()) {


        fun bind(model: OfficeLocationModel, view: View) {
            cellListGameResultBinding.model = model

        }
    }

}