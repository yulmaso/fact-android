package com.yulmaso.kskfact.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment: BaseFragment(), MenuAdapter.onMenuListener {

    private lateinit var viewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menu_rv.adapter = MenuAdapter(this)
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onMenuItemClick(menuItem: String) {
        when (menuItem) {
            resources.getString(R.string.profile_menu_item) -> {
                val bundle = Bundle()
                bundle.putLong("userId", viewModel.userId!!)
                findNavController().navigate(R.id.action_menuFragment_to_userProfileFragment, bundle)
            }
            resources.getString(R.string.settings_menu_item) ->
                findNavController().navigate(R.id.action_menuFragment_to_settingsFragment)
        }
    }
}