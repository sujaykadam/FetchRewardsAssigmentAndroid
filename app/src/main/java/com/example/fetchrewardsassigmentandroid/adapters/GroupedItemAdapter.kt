package com.example.fetchrewardsassigmentandroid.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsassigmentandroid.data.model.Item
import com.example.fetchrewardsassigmentandroid.databinding.ComponentGroupedItemBinding

class GroupedItemAdapter(private val groupedData: Map<Int, List<Item>>) :
    RecyclerView.Adapter<GroupedItemAdapter.GroupedViewHolder>() {

    private val keys = groupedData.keys.sorted()

    inner class GroupedViewHolder(val binding: ComponentGroupedItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupedViewHolder {
        val binding = ComponentGroupedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupedViewHolder, position: Int) {
        val listId = keys[position]
        holder.binding.tvListId.text = "List ID: " + listId
        holder.binding.innerRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.binding.innerRecyclerView.adapter = ItemAdapter(groupedData[listId]!!)
    }

    override fun getItemCount(): Int = keys.size
}
