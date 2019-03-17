package com.example.friyerr_mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    val mapsFragmentActivity  =  MapsActivity()
    val SearchFragmentActitivy = SearchFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MenuBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        this.setSupportActionBar(MenuTop)
        supportActionBar?.setTitle("")

        Log.d(TAG,"Affichage des menus")
        MenuTop.setNavigationIcon(R.drawable.ic_person_black_24dp)


        MenuBottom.menu.findItem(R.id.action_maps).setChecked(true)
        supportFragmentManager.beginTransaction().add(R.id.containter,mapsFragmentActivity)
            .add(R.id.containter,SearchFragmentActitivy)
            .commit()
        setTabStateFragment(TabState.MAPS)
        Log.d(TAG,"Fin d'affichage des menus")



    }

    private fun setTabStateFragment(state: TabState) {
        var transaction : FragmentTransaction =  supportFragmentManager.beginTransaction()

        when (state) {
            TabState.SEARCH -> {
                run {
                    transaction.show(SearchFragmentActitivy)
                    transaction.hide(mapsFragmentActivity)
                }

            }
            TabState.MAPS -> {
                run {
                    transaction.show(mapsFragmentActivity)
                    transaction.hide(SearchFragmentActitivy)
                }
            }

        }
        transaction.commit()
    }

    internal enum class TabState {
        SEARCH,
        MAPS
    }
    private fun SetFragment(frament: Fragment)
    {
        var fragmentTransation: FragmentTransaction =  supportFragmentManager.beginTransaction()
        fragmentTransation.replace(R.id.containter,frament)
        fragmentTransation.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_profile -> {
                setTabStateFragment(TabState.SEARCH)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_maps -> {
                setTabStateFragment(TabState.MAPS)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_main,menu)
        return true
    }


}
