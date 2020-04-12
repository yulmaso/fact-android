package com.yulmaso.kskfact.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentLoginBinding
import com.yulmaso.kskfact.ui.BaseFragment

class LoginFragment: BaseFragment() {

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

}