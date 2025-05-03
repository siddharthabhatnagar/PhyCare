package com.project.phycare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.phycare.MainActivityFragments.DashboardFragment
import com.project.phycare.MainActivityFragments.ProfileFragment
import com.project.phycare.MainActivityFragments.ThoughSharingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        replaceWithFragment(DashboardFragment())
        val bottomnav=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomnav.setOnItemSelectedListener {it->
            when(it.itemId){
                R.id.nav_dashboard-> {
                    replaceWithFragment(DashboardFragment())
                    true
                }
                R.id.nav_thoughts->{
                    replaceWithFragment(ThoughSharingFragment())
                    true
                }
                R.id.nav_profile->{
                    replaceWithFragment(ProfileFragment())
                    true
                }

                else -> {true}
            }
        }
    }
    fun replaceWithFragment(fragment: Fragment){
        val fm=supportFragmentManager
        val ft=fm.beginTransaction()
        ft.replace(R.id.framelayout,fragment)
        ft.commit()
    }
}