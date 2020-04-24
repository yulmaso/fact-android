package com.yulmaso.kskfact.ui.horses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.databinding.ItemHorsesBinding

class HorsesAdapter(
    private val mOnHorsesListener: OnHorsesListener
): RecyclerView.Adapter<HorsesAdapter.HorsesViewHolder>() {

    private val items: MutableList<Horse> = ArrayList()

    interface OnHorsesListener {
        fun onHorsesClick(horse: Horse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorsesViewHolder =
        HorsesViewHolder(ItemHorsesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), mOnHorsesListener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HorsesViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<Horse>) {
        if (!items.isNullOrEmpty()) {
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    inner class HorsesViewHolder(
        private val binding: ItemHorsesBinding,
        private val OnHorsesListener: OnHorsesListener
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(horse: Horse) {
            binding.apply {
                root.setOnClickListener(this@HorsesViewHolder)
                horsesName.text = horse.name
                horsesGenderAgeTitle.text = String.format(
                    "%s, %d %s",
                    arrayOf(horse.gender, horse.age, root.context.getString(R.string.hprofile_age))
                )
                horsesOwner.text = horse.owner!!.realname
            }
        }

        override fun onClick(p0: View?) {
            OnHorsesListener.onHorsesClick(items[layoutPosition])
        }
    }
}