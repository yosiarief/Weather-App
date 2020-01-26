package com.yosiarief.hipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navControl: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navControl = Navigation.findNavController(this, R.id.nav_host_fragment)

        bottom_nav.setupWithNavController(navControl)

        NavigationUI.setupActionBarWithNavController(this, navControl)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navControl, null)
    }
}
