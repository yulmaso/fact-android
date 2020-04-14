package com.yulmaso.kskfact.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment: BaseFragment(), MenuAdapter.onMenuListener {

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
            resources.getString(R.string.settings_menu_item) ->
                findNavController().navigate(R.id.action_menuFragment_to_settingsFragment)
        }
    }
}