package com.yulmaso.kskfact.ui.horseProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.HorseService
import com.yulmaso.kskfact.databinding.ItemInfoRowBinding
import com.yulmaso.kskfact.utils.Constants.dateFormat

class HProfileServicesAdapter :
    RecyclerView.Adapter<HProfileServicesAdapter.HProfileServicesViewHolder>() {

    private val items: MutableList<HorseService> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HProfileServicesViewHolder(
            ItemInfoRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HProfileServicesViewHolder, position: Int) =
        holder.bind(items[position])


    //TODO:: здесь нужны только ENABLED НЕ ПРОСРОЧЕННЫЕ услуги
    fun setItems(items: List<HorseService>?) {
        if (!items.isNullOrEmpty()) {
            this.items.apply {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        }
    }

    class HProfileServicesViewHolder(
        private val binding: ItemInfoRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service: HorseService) {
            binding.apply {
                infoContentTv.text = service.service?.name
                infoDescriptionTv.text =
                    String.format("%s %s", arrayOf("до", dateFormat.format(service.endTime!!.time)))
            }
        }
    }
}