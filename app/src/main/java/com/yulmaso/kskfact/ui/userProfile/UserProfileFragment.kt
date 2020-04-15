package com.yulmaso.kskfact.ui.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentUserProfileBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment

class UserProfileFragment: BaseFragment() {

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUserProfileBinding>(
            inflater, R.layout.fragment_user_profile, container, false
        )
        binding.apply {
            viewmodel = viewModel
        }
        return binding.root
    }

}