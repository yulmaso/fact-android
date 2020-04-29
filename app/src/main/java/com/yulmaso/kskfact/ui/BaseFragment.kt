package com.yulmaso.kskfact.ui

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.kskfact.ui.dialogFragments.LoadingDialogFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var loadingDialog: LoadingDialogFragment

    fun showProgressBar(fm: FragmentManager) = loadingDialog.show(fm, "Loading")

    fun dismissProgressBar() {
        if (loadingDialog.isVisible) loadingDialog.dismiss()
    }

    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}