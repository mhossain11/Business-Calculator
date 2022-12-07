package com.example.calculator_for_agg.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator_for_agg.databinding.RowAggBinding
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.listenerClick

class AggAdapter(val listener :listenerClick) : ListAdapter<AggData, AggAdapter.AggViewHolder>(DiffCallBack()) {
    private lateinit var binding: RowAggBinding

    class AggViewHolder(private var binding: RowAggBinding, val listener :listenerClick) : RecyclerView.ViewHolder(binding.root) {

        fun bind(aggData: AggData) {
            binding.agg = aggData
            binding.deleteBtn.setOnClickListener {

                listener.onDeleteListener(aggData)
            }

            binding.editBtn.setOnClickListener {
                listener.onEditListener(aggData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AggViewHolder {
        binding = RowAggBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AggViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: AggViewHolder, position: Int) {
        val item: AggData = getItem(position)
        holder.bind(item)
    }

}

class DiffCallBack : DiffUtil.ItemCallback<AggData>() {
    override fun areItemsTheSame(oldItem: AggData, newItem: AggData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AggData, newItem: AggData): Boolean {
        return oldItem == newItem
    }

}