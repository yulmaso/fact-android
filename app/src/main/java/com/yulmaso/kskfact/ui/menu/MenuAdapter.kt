package com.yulmaso.kskfact.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.ItemMenuBinding

class MenuAdapter(
    private val mOnMenuListener: onMenuListener
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    interface onMenuListener {
        fun onMenuItemClick(menuItem: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), mOnMenuListener)

    override fun getItemCount() = 5

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        when (position) {
            0 -> holder.bind(R.drawable.ic_profile, R.string.profile_menu_item)
            1 -> holder.bind(R.drawable.ic_horse, R.string.horses_menu_item)
            2 -> holder.bind(R.drawable.ic_employee, R.string.employees_menu_item)
            3 -> holder.bind(R.drawable.ic_camera, R.string.cameras_menu_item)
            4 -> holder.bind(R.drawable.ic_settings, R.string.settings_menu_item)
        }
    }

    class MenuViewHolder(
        private val binding: ItemMenuBinding,
        private val onMenuListener: onMenuListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(icon: Int, name: Int) {
            binding.apply {
                root.setOnClickListener(this@MenuViewHolder)
                menuIv.setImageResource(icon)
                menuTv.setText(name)
            }
        }
        override fun onClick(p0: View?) {
            onMenuListener.onMenuItemClick(binding.menuTv.text.toString())
        }

    }
}