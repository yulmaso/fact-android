package com.yulmaso.kskfact.ui

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.kskfact.ui.dialogFragments.LoadingDialogFragment
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject

abstract class BaseDialogFragment: DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var loadingDialog: LoadingDialogFragment

    fun showProgressBar(fm: FragmentManager) = loadingDialog.show(fm, "Loading")

    fun dismissProgressBar() {
        if (loadingDialog.isVisible) loadingDialog.dismiss()
    }

}