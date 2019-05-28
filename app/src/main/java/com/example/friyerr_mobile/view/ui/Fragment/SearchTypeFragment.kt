package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.friyerr_mobile.R


class SearchTypeFragment : Fragment() {
    companion object {
        val TAG :String ="SearchType"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type, container, false)

        var btnColocation  =  rootView.findViewById<Button>(R.id.BtnColocation)
        var btnLocation=  rootView.findViewById<Button>(R.id.BtnLocation)

        btnColocation.setOnClickListener{
            val childFragment = SearchTypeColocationFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTypeColocationFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }

        btnLocation.setOnClickListener{
            val childFragment = SearchTypeLocationFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(SearchFragment.TAG)?.commit()
        }

        return rootView
    }
}
