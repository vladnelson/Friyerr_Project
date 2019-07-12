package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.fragment_search_min_rate_recommandation.*

class SearchMinRateRecommandation : Fragment() {
    companion object {
        val TAG :String ="SearchMinRateRecommondation"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView =inflater.inflate(R.layout.fragment_search_min_rate_recommandation, container, false)
        var btnSearchForSearchRateMin =  rootView.findViewById<Button>(R.id.BtnSearchForSearchRateMin)
        var imgReturnForSearchRateMin= rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchRateMin)

        btnSearchForSearchRateMin.setOnClickListener{
            val childFragment = SearchResultFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchResultFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }

        imgReturnForSearchRateMin.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        return rootView
    }
}
