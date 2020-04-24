package com.yulmaso.kskfact.ui.horseProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentHorseProfileBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener

class HorseProfileFragment: BaseFragment(), RequestListener, HorseProfileNavigator {

    private lateinit var viewModel: HorseProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.navigator = this
        viewModel.requestListener = this
        viewModel.horseId = requireArguments().getLong("horseId")
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
        }
        return binding.root
    }

    override fun goToVaccinationsHistory() {
        TODO("Not yet implemented")
    }

    override fun openAdditionalServiceDialog() {
        TODO("Not yet implemented")
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