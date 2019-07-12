package com.example.friyerr_mobile.view.ui.Fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.view.ui.activity.MainActivity


class SearchTypeFragment : Fragment() {
    companion object {
        val TAG :String ="SearchType"
        var CompteurState= 1
        var progres = 17
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type, container, false)

        var btnColocation  =  rootView.findViewById<Button>(R.id.BtnColocation)
        var btnLocation=  rootView.findViewById<Button>(R.id.BtnLocation)

        var pgrLocation=  rootView.findViewById<ProgressBar>(R.id.progressBar4)


        var obj : ObjectAnimator = ObjectAnimator.ofInt(pgrLocation,"progress",MainActivity.CompteurStateOld,
            progres
        )
        obj.duration=500
        obj.interpolator= LinearInterpolator()
        obj.start()
       MainActivity.ChangeProgreeAnim(pgrLocation,progres,"azer")

        MainActivity.CompteurStateOld= progres

        var ssde = savedInstanceState?.getString("Statut")

        if (ssde !=  null){
            Log.d(TAG,ssde)
        }



        btnColocation.setOnClickListener{

            val transaction = fragmentManager?.beginTransaction()

            var data =  Bundle()
            data.putString("Statut","Return")

            var childFragment = SearchTypeColocationFragment()
            childFragment.arguments=data

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
