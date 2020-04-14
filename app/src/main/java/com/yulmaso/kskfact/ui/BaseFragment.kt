package com.yulmaso.kskfact.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.kskfact.ui.dialogFragments.LoadingDialogFragment
import javax.inject.Inject

abstract class BaseFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var loadingDialog: LoadingDialogFragment

    fun showProgressBar() = loadingDialog.show(activity!!.supportFragmentManager, "Loading")

    fun dismissProgressBar() = loadingDialog.dismiss()

}