package com.example.friyerr_mobile.view.ui.Fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.view.ui.activity.MainActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_search_type_colocation.*



class SearchTypeColocationFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypeColocation"
        var progres = 38
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type_colocation, container, false)

        var btnHouseForTypeColocation =  rootView.findViewById<Button>(R.id.BtnHouseForTypeColocation)
        var btnFlatForTypeColocation =  rootView.findViewById<Button>(R.id.BtnAppartementForTypeColocation)
        var imgReturnForSearcheTypeColocation =rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchTypecolocation)

        var pgrLocation=  rootView.findViewById<ProgressBar>(R.id.progressBar3)

        var obj : ObjectAnimator = ObjectAnimator.ofInt(pgrLocation,"progress",MainActivity.CompteurStateOld,progres)
        obj.duration=500
        obj.interpolator= LinearInterpolator()
        obj.start()
        MainActivity.CompteurStateOld= progres

        var ssde = savedInstanceState?.getString("Statut")
        if (ssde !=  null){
            Log.d(TAG,ssde)
        }

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
