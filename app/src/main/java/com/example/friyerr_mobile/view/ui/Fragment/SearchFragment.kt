package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friyerr_mobile.R


class SearchFragment : Fragment() {

    private  var transaction : FragmentTransaction?  = null
    companion object {
         val TAG :String ="SearchFragment"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search, container, false)
        val childFragment = SearchTypeFragment()
        transaction = childFragmentManager.beginTransaction()
        transaction?.replace(R.id.containterSearch, childFragment,SearchTypeFragment.TAG)?.addToBackStack(null)?.commit()
        return rootView
    }
}