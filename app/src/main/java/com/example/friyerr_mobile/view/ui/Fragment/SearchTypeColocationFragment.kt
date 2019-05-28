package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_search_type_colocation.*



class SearchTypeColocationFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypeColocation"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type_colocation, container, false)

        var btnHouseForTypeColocation =  rootView.findViewById<Button>(R.id.BtnHouseForTypeColocation)
        var btnFlatForTypeColocation =  rootView.findViewById<Button>(R.id.BtnAppartementForTypeColocation)
        var imgReturnForSearcheTypeColocation =rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchTypecolocation)

        btnHouseForTypeColocation.setOnClickListener{
            val childFragment = SearchTownFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTownFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }

        btnFlatForTypeColocation.setOnClickListener{
            val childFragment = SearchTownFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTownFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }
        imgReturnForSearcheTypeColocation.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        return rootView
    }


}