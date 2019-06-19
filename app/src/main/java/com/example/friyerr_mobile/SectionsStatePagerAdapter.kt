package com.example.friyerr_mobile


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

public class SectionsStatePagerAdapter(val fn : FragmentManager) : FragmentStatePagerAdapter(fn){

    val mFragmentList = ArrayList<Fragment>()
    val mFragmentListTitleList = ArrayList<String>()


    public fun addFragment(fragment: Fragment, title:String ){
        mFragmentList.add(fragment)
        mFragmentListTitleList.add(title)
    }

    override fun getItem(postion: Int): Fragment {
        return mFragmentList[postion]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}