package com.yulmaso.kskfact.ui.horses

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.databinding.ItemHorsesBinding

class HorsesAdapter(
    private val mOnHorsesListener: onHorsesListener
): RecyclerView.Adapter<HorsesAdapter.HorsesViewHolder>() {

    //TODO
    private val horses: MutableList<Int> = ArrayList()

    interface onHorsesListener {
        fun onHorsesClick(horseName: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorsesViewHolder =
        HorsesViewHolder(ItemHorsesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), mOnHorsesListener)

    override fun getItemCount() = horses.size

    override fun onBindViewHolder(holder: HorsesViewHolder, position: Int) =
        holder.bind()

    //TODO
    fun setItems() {}

    class HorsesViewHolder(
        private val binding: ItemHorsesBinding,
        private val onHorsesListener: onHorsesListener
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        //TODO
        fun bind() {

        }

        override fun onClick(p0: View?) {
            onHorsesListener.onHorsesClick(binding.horsesName.text.toString())
        }
    }
}