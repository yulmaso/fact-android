package com.yulmaso.kskfact.ui.horseProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.HorseAccess
import com.yulmaso.kskfact.databinding.ItemInfoRowBinding
import com.yulmaso.kskfact.utils.makePositionsString

class HProfileAccessAdapter : RecyclerView.Adapter<HProfileAccessAdapter.ViewHolder>() {

    private val items: MutableList<HorseAccess> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemInfoRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<HorseAccess>?) {
        if (!items.isNullOrEmpty()) {
            this.items.apply {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        val binding: ItemInfoRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(access: HorseAccess) {
            binding.apply {
                infoContentTv.text = access.user?.realname
                infoDescriptionTv.text = makePositionsString(access.userPosition)
            }
        }
    }
}