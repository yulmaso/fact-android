package com.yulmaso.kskfact.ui.horseProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.Vaccination
import com.yulmaso.kskfact.databinding.FragmentHorseProfileBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener
import com.yulmaso.kskfact.ui.dialogFragments.addService.AddServiceDialogFragment

class HorseProfileFragment: BaseFragment(), RequestListener, HProfileVaccinationsAdapter.OnVaccinationListener,
    HorseProfileNavigator {

    private lateinit var viewModel: HorseProfileViewModel

    private lateinit var accessAdapter: HProfileAccessAdapter
    private lateinit var serviceAdapter: HProfileServicesAdapter
    private lateinit var vaccinationsAdapter: HProfileVaccinationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.navigator = this
        viewModel.requestListener = this

        accessAdapter = HProfileAccessAdapter()
        serviceAdapter = HProfileServicesAdapter()
        vaccinationsAdapter = HProfileVaccinationsAdapter(this)

        viewModel.horse.observe(viewLifecycleOwner, Observer {
            accessAdapter.setItems(it.horseAccess)
            serviceAdapter.setItems(it.horseServices)
            vaccinationsAdapter.setItems(it.horseVaccinations)
        })
        viewModel.setProfileHorse(requireArguments().getSerializable("horse") as Horse)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHorseProfileBinding>(
            inflater, R.layout.fragment_horse_profile, container, false
        )
        binding.apply {
            viewmodel = viewModel
            hprofileAccessRv.adapter = accessAdapter
            hprofileServicesRv.adapter = serviceAdapter
            hprofilePlanningVaccinationsRv.adapter = vaccinationsAdapter
        }
        return binding.root
    }

    override fun goToVaccinationsHistory(horse: Horse) {
        val bundle = Bundle()
        bundle.putSerializable("horse", horse)
        findNavController()
            .navigate(R.id.action_horseProfileFragment_to_vaccinationsHistoryFragment, bundle)
    }

    override fun openAddServiceDialog() {
        val addServiceDialogFragment = AddServiceDialogFragment(viewModel.horse.value!!)
        addServiceDialogFragment.show(childFragmentManager, "addServiceDialog")
    }

    override fun cancelVaccination(vaccination: Vaccination) =
        viewModel.cancelVaccination(vaccination)

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