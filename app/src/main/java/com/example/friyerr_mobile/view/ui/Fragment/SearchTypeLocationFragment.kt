package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.fragment_search_type_location.*


class SearchTypeLocationFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypeLolocation"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView = inflater.inflate(R.layout.fragment_search_type_location, container, false)

        var btnHouseFortTypelocation =  rootView.findViewById<Button>(R.id.BtnHouseForTypelocation)
        var btnFlatForTypelocation = rootView.findViewById<Button>(R.id.BtnAppartementForTypelocation)
        var imgReturnForSearchTypeLocation  = rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchTypelocation)

        btnHouseFortTypelocation.setOnClickListener{
            val childFragment = SearchTownFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTownFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }

        btnFlatForTypelocation.setOnClickListener{
            val childFragment = SearchTownFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTownFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }
        imgReturnForSearchTypeLocation.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        return rootView
    }

}
