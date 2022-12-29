package com.example.footballview.presentation.CompStandingsTable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballview.databinding.CompStandingsTableItemBinding
import com.example.footballview.domain.entity.StrTable
import com.example.footballview.presentation.common.setImageUrl

class CompStandingsTableAdapter() : ListAdapter<StrTable, CompStandingsTableAdapter.Holder>(
    object : DiffUtil.ItemCallback<StrTable>() {
        override fun areItemsTheSame(oldItem: StrTable, newItem: StrTable): Boolean {
            return oldItem.TeamName == newItem.TeamName
        }

        override fun areContentsTheSame(oldItem: StrTable, newItem: StrTable): Boolean {
            return oldItem == newItem
        }
    }
) {

    fun setData(strTableList : List<StrTable>) {
        submitList(strTableList)
    }

    class Holder(val binding: CompStandingsTableItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =  CompStandingsTableItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            competitionStandingsTableItemName.text = item.TeamName
            competitionStandingsTableItemPosition.text = item.TeamPosition.toString()
            competitionStandingsTableItemPoster.setImageUrl(item.TeamPosterUrl)
            competitionStandingsTableItemPoints.text = item.TeamPoints.toString()
        }
    }
}