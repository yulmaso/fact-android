package com.yulmaso.kskfact.ui.login

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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
    private lateinit var binding: FragmentLoginBinding

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
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )
        binding.viewmodel = viewModel
        val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.apply {
            loginEt.clearFocus()
            passwordEt.clearFocus()
        }
        hideKeyboard(requireContext(), requireView().rootView)
    }

    override fun onPause() {
        super.onPause()
        binding.apply {
            loginEt.clearFocus()
            passwordEt.clearFocus()
        }
        hideKeyboard(requireContext(), requireView().rootView)
    }

    override fun onStarted() {
        showProgressBar(childFragmentManager)
    }

    override fun onSuccess() {
        dismissProgressBar()
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToTimetableFragment())
    }

    override fun onFailure(message: String) {
        dismissProgressBar()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}