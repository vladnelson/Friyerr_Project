package com.example.friyerr_mobile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

public class SectionsStatePagerAdapter(val fn : FragmentManager) : FragmentStatePagerAdapter(fn){

    val mFragmentList = ArrayList<Fragment>()
    val mFragmentListTitleList = ArrayList<String>()


    public fun addFragment(fragment: Fragment, title:String ){
        mFragmentList.add(fragment)
        mFragmentListTitleList.add(title)
    }

    override fun getItem(postion: Int): Fragment? {
        return mFragmentList[postion]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}