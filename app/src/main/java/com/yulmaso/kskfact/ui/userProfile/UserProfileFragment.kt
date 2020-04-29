package com.yulmaso.kskfact.ui.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentUserProfileBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener

class UserProfileFragment: BaseFragment(), RequestListener {

    private lateinit var viewModel: UserProfileViewModel
    private lateinit var adapter: UserProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this
        viewModel.updateData(requireArguments().getLong("userId"))

        adapter = UserProfileAdapter()
        viewModel.user.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it.horseAccess)
        })
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
            uprofileHorseAccessRv.adapter = adapter
        }
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