package com.example.okesampah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.okesampah.activity.LoginActivity
import com.example.okesampah.activity.MasukActivity
import com.example.okesampah.fragment.DashboardFragment
import com.example.okesampah.fragment.HomeFragment
import com.example.okesampah.fragment.PelangganFragment
import com.example.okesampah.fragment.ProfilFragment
import com.example.okesampah.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val fragmentHome : Fragment = HomeFragment()
    private val fragmentDashboard : Fragment = DashboardFragment()
    private val fragmentPelanggan : Fragment = PelangganFragment()
    private val fragmentProfil : Fragment = ProfilFragment()
    private val fm : FragmentManager = supportFragmentManager
    private var active : Fragment = fragmentHome

    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()
    }

    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container,fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container,fragmentDashboard).hide(fragmentDashboard).commit()
        fm.beginTransaction().add(R.id.container,fragmentPelanggan).hide(fragmentPelanggan).commit()
        fm.beginTransaction().add(R.id.container,fragmentProfil).hide(fragmentProfil).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener {  item ->
            when(item.itemId){
                R.id.navigation_home -> {
                    callFragment(0,fragmentHome)
                }
                R.id.navigation_dashboard -> {
                    callFragment(1,fragmentDashboard)
                }
                R.id.navigation_pelanggan -> {
                    callFragment(2,fragmentPelanggan)
                }
                R.id.navigation_profil -> {
                    if(s.getStatusLogin()){
                        callFragment(3,fragmentProfil)
                    }else{
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }
    }
    fun callFragment(int: Int,fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active ).show(fragment).commit()
        active = fragment
    }
}