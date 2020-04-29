package com.yulmaso.kskfact.ui.vaccinationsHistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.databinding.FragmentVaccinationsHistoryBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener
import kotlinx.android.synthetic.main.fragment_vaccinations_history.*

class VaccinationsHistoryFragment : BaseFragment(), RequestListener {
    private lateinit var viewModel: VaccinationsHistoryViewModel
    private lateinit var adapter: VaccinationHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.vaccinationsMLive.value = viewModel.horse!!.horseVaccinations

        adapter = VaccinationHistoryAdapter()
        viewModel.vaccinations.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
        viewModel.horse = requireArguments().getSerializable("horse") as Horse
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVaccinationsHistoryBinding.inflate(
            inflater, container, false
        )
        binding.vacHistoryRv.adapter = adapter
        return binding.root
    }

    override fun onStarted() {
        showProgressBar(childFragmentManager)
    }

    override fun onSuccess() {
        dismissProgressBar()
    }

    override fun onFailure(message: String) {
        dismissProgressBar()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}