package com.yulmaso.kskfact.di

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

inline fun <reified T : ViewModel> DialogFragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}
