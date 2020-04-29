package com.yulmaso.kskfact.ui.news

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.News
import com.yulmaso.kskfact.databinding.ItemNewsBinding
import com.yulmaso.kskfact.databinding.ItemNewsBindingImpl
import com.yulmaso.kskfact.utils.Constants.LOG_TAG
import com.yulmaso.kskfact.utils.Constants.dateFormat
import com.yulmaso.kskfact.utils.Constants.timeFormat

class NewsAdapter(val onNewsListener: OnNewsListener):
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val items: MutableList<News> = ArrayList()

    interface OnNewsListener{
        fun emptyList()
        fun notEmptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(ItemNewsBindingImpl.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<News>?) {
        if (!items.isNullOrEmpty()) {
            onNewsListener.notEmptyList()
            this.items.apply {
                clear()
                addAll(items)
                Log.d(LOG_TAG, items[0].toString())
            }
            notifyDataSetChanged()
        } else {
            onNewsListener.emptyList()
        }
    }

    class NewsViewHolder(
        private val binding: ItemNewsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.apply {
                newsHeader.text = news.title
                newsContent.text = news.content
                newsTime.text = "${dateFormat.format(news.time!!.time)} в ${timeFormat.format(news.time!!.time)}"
            }
        }
    }
}