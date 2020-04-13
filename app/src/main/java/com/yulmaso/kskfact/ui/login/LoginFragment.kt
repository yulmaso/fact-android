package com.yulmaso.kskfact.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentLoginBinding
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener
import com.yulmaso.kskfact.di.injectViewModel

class LoginFragment: BaseFragment(),  RequestListener {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )
        return binding.root
    }

    override fun onStarted() {
        loadingDialog.show(activity!!.supportFragmentManager, "Loading")
    }

    override fun onSuccess() {
        loadingDialog.dismiss()
        findNavController().navigate(R.id.action_loginFragment_to_timetableFragment)
    }

    override fun onFailure(message: String) {
        loadingDialog.dismiss()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}