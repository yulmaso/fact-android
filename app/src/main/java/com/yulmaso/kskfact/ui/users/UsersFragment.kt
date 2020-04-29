package com.yulmaso.kskfact.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.databinding.FragmentUsersBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener

class UsersFragment: BaseFragment(), RequestListener, UsersAdapter.OnUsersClickListener {

    private lateinit var viewModel: UsersViewModel
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this

        adapter = UsersAdapter(this)
        viewModel.users.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUsersBinding.inflate(
            inflater, container, false
        )
        binding.usersRv.adapter = adapter
        return binding.root
    }

    override fun onUserClick(user: User) {
        val bundle = Bundle()
        bundle.putLong("userId", user.id!!)
        findNavController().navigate(R.id.action_usersFragment_to_userProfileFragment, bundle)
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