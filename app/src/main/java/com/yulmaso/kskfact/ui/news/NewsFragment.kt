package com.yulmaso.kskfact.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentNewsBinding
import com.yulmaso.kskfact.databinding.FragmentNewsBindingImpl
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener

class NewsFragment: BaseFragment(), NewsAdapter.OnNewsListener, RequestListener {

    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    private var binding: FragmentNewsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this
        viewModel.updateData()
        adapter = NewsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBindingImpl.inflate(
            inflater, container, false
        )
        binding!!.apply {
            viewmodel = viewModel
            newsRv.adapter = adapter
        }

        viewModel.news.observe(viewLifecycleOwner, Observer {
            binding!!.newsNoItemsYet.visibility = View.GONE
            adapter.setItems(it)
        })

        return binding!!.root
    }

    override fun emptyList() {
        binding?.newsNoItemsYet?.visibility = View.VISIBLE
    }

    override fun notEmptyList() {
        binding?.newsNoItemsYet?.visibility = View.GONE
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}