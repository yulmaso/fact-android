package com.yulmaso.kskfact

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            //Handling BottomNavigationView
            when (destination.id) {
                R.id.timetableFragment, R.id.menuFragment, R.id.newsFragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
                else -> {
                    bottomNavigationView.visibility = View.GONE
                }
            }

            //Handling Status Bar
            when (destination.id) {
                //Dark Status Bar
                R.id.timetableFragment, R.id.horsesFragment, R.id.usersFragment -> {
                    window.statusBarColor = resources.getColor(R.color.colorPrimary)
                    var flags = window.decorView.systemUiVisibility
                    flags = flags and flags.inv()
                    window.decorView.systemUiVisibility = flags

                }
                //Light Status Bar
                else -> {
                    window.statusBarColor = resources.getColor(R.color.background)
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }
    }
}
