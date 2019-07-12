package com.example.friyerr_mobile.view.ui.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.SettingsActivity
import com.example.friyerr_mobile.view.ui.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object {
        val TAG = "MainActivity"
        var CompteurStateOld = 0


        fun ChangeProgreeAnim(PbAnim: ProgressBar, ProgresStop: Int , PropertyN : String) {

            Log.d(TAG,"On va progress de " + CompteurStateOld +"  à " + ProgresStop)
           // if (CompteurStateOld > ProgresStop) {
                var obj: ObjectAnimator = ObjectAnimator.ofInt(
                    PbAnim,
                    PropertyN,
                    CompteurStateOld,
                    ProgresStop

                )
                obj.duration = 500
                obj.interpolator = LinearInterpolator()
                obj.start()


        }
    }


    val MapsFragmentActivity = MapsFragment()
    val SearchFragmentActitivy = SearchFragment()
    val ProfileFragmentActivity = ProfileFragment()
    val FavorisFragmentActivity = FavoriteSportsFragment()
    val MessangerFragmentActivity = MessagerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MenuBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setSupportActionBar(MenuTop)
        supportActionBar?.setTitle("")

        Log.d(TAG, "Affichage des menus")
        // MenuTop.setNavigationIcon(R.drawable.ic_person_black_24dp)
        // MenuTop.setNavigationOnClickListener{
//Log.d(TAG,"Cliquer sur le profil"+MenuBottom.selectedItemId)

        //}

        setTabStateFragment(TabState.MAPS)
        supportFragmentManager.beginTransaction()
            .add(R.id.containter, MapsFragmentActivity)
            .add(R.id.containter, SearchFragmentActitivy)
            .add(R.id.containter, ProfileFragmentActivity)
            .add(R.id.containter, FavorisFragmentActivity)
            .add(R.id.containter, MessangerFragmentActivity)
            .commit()

        MenuBottom.menu.findItem(R.id.action_maps).isChecked = true
        // setTabStateFragment(TabState.MAPS)

        Log.d(TAG, "Fin d'affichage des menus")
    }

    private fun setTabStateFragment(state: TabState) {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        when (state) {
            TabState.SEARCH -> {
                run {
                    transaction.show(SearchFragmentActitivy)
                    transaction.hide(MapsFragmentActivity)
                    transaction.hide(ProfileFragmentActivity)
                    transaction.hide(FavorisFragmentActivity)
                    transaction.hide(MessangerFragmentActivity)
                }

            }
            TabState.FAVORIS -> {
                run {
                    transaction.show(FavorisFragmentActivity)
                    transaction.hide(SearchFragmentActitivy)
                    transaction.hide(ProfileFragmentActivity)
                    transaction.hide(MapsFragmentActivity)
                    transaction.hide(MessangerFragmentActivity)
                }

            }
            TabState.MAPS -> {
                run {
                    transaction.show(MapsFragmentActivity)
                    transaction.hide(SearchFragmentActitivy)
                    transaction.hide(ProfileFragmentActivity)
                    transaction.hide(FavorisFragmentActivity)
                    transaction.hide(MessangerFragmentActivity)

                }
            }
            TabState.PROFILE -> {
                run {
                    transaction.show(ProfileFragmentActivity)
                    transaction.hide(SearchFragmentActitivy)
                    transaction.hide(MapsFragmentActivity)
                    transaction.hide(FavorisFragmentActivity)
                    transaction.hide(MessangerFragmentActivity)
                }
            }
            TabState.MESSENGER -> {
                run {
                    transaction.show(MessangerFragmentActivity)
                    transaction.hide(SearchFragmentActitivy)
                    transaction.hide(MapsFragmentActivity)
                    transaction.hide(FavorisFragmentActivity)
                    transaction.hide(ProfileFragmentActivity)
                }
            }
        }
        transaction.commit()
    }

    internal enum class TabState {
        SEARCH,
        FAVORIS,
        MESSENGER,
        MAPS,
        PROFILE
    }

    private fun SetFragment(frament: Fragment) {
        var fragmentTransation: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransation.replace(R.id.containter, frament)
        fragmentTransation.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_Search -> {
                setTabStateFragment(TabState.SEARCH)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_maps -> {
                setTabStateFragment(TabState.MAPS)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_profile -> {
                setTabStateFragment(TabState.PROFILE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_Favoris -> {
                setTabStateFragment(TabState.FAVORIS)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_messenger -> {
                setTabStateFragment(TabState.MESSENGER)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}
