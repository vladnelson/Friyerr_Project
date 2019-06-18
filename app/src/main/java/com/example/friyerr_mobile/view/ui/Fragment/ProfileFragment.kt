package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.RequestApi.PostRequestLogout
import com.example.friyerr_mobile.view.adapter.ViewPagerAdapter
import com.squareup.picasso.Picasso


class ProfileFragment : Fragment()  {
    private  var transaction : FragmentTransaction?  = null
    companion object {
        val TAG : String = "ProfileFragment"
    }

    private val tabIcons = intArrayOf(R.drawable.ic_action_globe, R.drawable.ic_action_globe)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        Log.d(TAG,"Je suis dans profile")
        //var viewPager = rootView.findViewById<ViewPager>(R.id.containterFavorite)
      //  var tabLayout =  rootView.findViewById<TabLayout>(R.id.tabs)
        var ImageProfile  =  rootView.findViewById<ImageView>(R.id.ImgProfile)

        Picasso.with(this.activity)
            .load("https://heritagevillagecincinnati.org/wp-content/uploads/2017/12/icon.png")
            .into(ImageProfile)

        //setUpViewPager(viewPager)

        //viewPager.currentItem = 0

        //tabLayout.setupWithViewPager(viewPager)
        var mBtnLogoutForInformation = rootView.findViewById<LinearLayout>(R.id.BtnLogoutForInformation)

        mBtnLogoutForInformation.setOnClickListener {
            mBtnLogoutForInformation.isClickable = false
            PostRequestLogout(rootView,activity).execute()

        }


        //val childFragment = this
        //transaction = childFragmentManager.beginTransaction()
        //transaction?.replace(R.id.containterFavorite, childFragment,ProfileFragment.TAG)?.addToBackStack(null)?.commit()
        return rootView
    }


    private fun setUpViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(fragmentManager)
        adapter.addFragment(FavoriteSportsFragment(), "FAVORITE SPOTS")
     //   adapter.addFragment(InformationFragment(), "INFORMATIONS")
        viewPager.adapter = adapter
    }
}
