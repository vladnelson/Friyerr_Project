package com.example.friyerr_mobile.view.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.nio.file.Files.size



class ViewPagerAdapter(fm : FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }


    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }
}