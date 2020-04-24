package com.yulmaso.kskfact.ui.horses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.databinding.FragmentHorsesBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener
import kotlinx.android.synthetic.main.fragment_horses.*

class HorsesFragment: BaseFragment(), HorsesAdapter.OnHorsesListener, RequestListener {

    private lateinit var viewModel: HorsesViewModel
    private lateinit var adapter: HorsesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this

        adapter = HorsesAdapter(this)
        viewModel.horses.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHorsesBinding.inflate(
            inflater, container, false
        )
        binding.horsesRv.adapter = adapter
        return binding.root
    }

    override fun onHorsesClick(horse: Horse) {
        val bundle = Bundle()
        bundle.putLong("horseId", horse.id!!)
        findNavController().navigate(R.id.action_horsesFragment_to_horseProfileFragment, bundle)
    }

    override fun onStarted() {
        showProgressBar()
    }

    override fun onSuccess() {
        showProgressBar()
    }

    override fun onFailure(message: String) {
        dismissProgressBar()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}