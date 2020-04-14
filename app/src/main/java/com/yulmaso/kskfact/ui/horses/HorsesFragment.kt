package com.yulmaso.kskfact.ui.horses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_horses.*

class HorsesFragment: BaseFragment(), HorsesAdapter.onHorsesListener {

    private lateinit var viewModel: HorsesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        horses_rv.adapter = HorsesAdapter(this)
        return inflater.inflate(R.layout.fragment_horses, container, false)
    }

    override fun onHorsesClick(horseName: String) {
        TODO("Not yet implemented")
    }
}