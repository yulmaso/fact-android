package com.yulmaso.kskfact.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.databinding.ItemUsersBinding
import com.yulmaso.kskfact.utils.makePositionsString

class UsersAdapter(
    private val onUsersClickListener: OnUsersClickListener
): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private val items: MutableList<User> = ArrayList()

    interface OnUsersClickListener{
        fun onUserClick(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UsersViewHolder(ItemUsersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), onUsersClickListener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<User>) {
        if (!items.isNullOrEmpty()) {
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    inner class UsersViewHolder(
        private val binding: ItemUsersBinding,
        private val onUsersClickListener: OnUsersClickListener
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(user: User) {
            binding.apply {
                root.setOnClickListener(this@UsersViewHolder)
                usersNameTv.text = user.realname
                usersPositionTv.text = makePositionsString(user.positions)
            }
        }
        override fun onClick(p0: View?) {
            onUsersClickListener.onUserClick(items[layoutPosition])
        }
    }
}