package com.yulmaso.kskfact.ui.dialogFragments.addService

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.databinding.ItemInfoRowBinding

class AddServiceDialogAdapter(private val onAddServiceListener: OnAddServiceListener) :
    RecyclerView.Adapter<AddServiceDialogAdapter.AddServiceViewHolder>() {

    private val items: MutableList<Service> = ArrayList()

    interface OnAddServiceListener {
        fun onServiceClick(service: Service)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AddServiceViewHolder(
            ItemInfoRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onAddServiceListener
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AddServiceViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<Service>?) {
        if (!items.isNullOrEmpty()) {
            this.items.apply {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        }
    }

    inner class AddServiceViewHolder(
        private val binding: ItemInfoRowBinding,
        private val onAddServiceListener: OnAddServiceListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(service: Service) {
            binding.apply {
                root.setOnClickListener(this@AddServiceViewHolder)
                infoContentTv.text = service.name
                infoDescriptionTv.text = service.price.toString()
            }
        }

        override fun onClick(p0: View?) {
            onAddServiceListener.onServiceClick(items[layoutPosition])
        }
    }
}