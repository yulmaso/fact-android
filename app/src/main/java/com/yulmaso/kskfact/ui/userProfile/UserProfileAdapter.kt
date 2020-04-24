package com.yulmaso.kskfact.ui.userProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.HorseAccess
import com.yulmaso.kskfact.databinding.ItemInfoRowBinding
import com.yulmaso.kskfact.utils.makePositionsString

class UserProfileAdapter: RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    private var items: MutableList<HorseAccess> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserProfileViewHolder(ItemInfoRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false ))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<HorseAccess>?) {
        if (!items.isNullOrEmpty()) {
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    class UserProfileViewHolder(
        private val binding: ItemInfoRowBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(horseAccess: HorseAccess) {
            binding.infoContentTv.text = horseAccess.horse!!.name
            binding.infoDescriptionTv.text = makePositionsString(horseAccess.userPosition)
        }
    }
}