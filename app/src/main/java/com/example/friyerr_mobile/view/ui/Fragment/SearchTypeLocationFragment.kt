package com.example.friyerr_mobile.view.ui.Fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.view.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_search_type_location.*


class SearchTypeLocationFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypeLolocation"
        var CompteurState= 2
        var progres = 38
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView = inflater.inflate(R.layout.fragment_search_type_location, container, false)

        var btnHouseFortTypelocation =  rootView.findViewById<Button>(R.id.BtnHouseForTypelocation)
        var btnFlatForTypelocation = rootView.findViewById<Button>(R.id.BtnAppartementForTypelocation)
        var imgReturnForSearchTypeLocation  = rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchTypelocation)
        var pGB =rootView.findViewById<ProgressBar>(R.id.ProgressbarForLocation)

       // MainActivity.ChangeProgreeAnim(pGB, progres,"zqdqzd")
        var obj : ObjectAnimator = ObjectAnimator.ofInt(pGB,"progress",MainActivity.CompteurStateOld, progres)
        obj.duration=500
        obj.interpolator= LinearInterpolator()
        obj.start()

        MainActivity.CompteurStateOld= progres


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
