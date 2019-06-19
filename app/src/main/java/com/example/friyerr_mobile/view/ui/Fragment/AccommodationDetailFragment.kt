package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.friyerr_mobile.R

class AccommodationDetailFragment : Fragment() {
    companion object {
        val TAG :String ="AccomodationDetail"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView =  inflater.inflate(R.layout.fragment_accommodation_detail, container, false)



        return  rootView
    }


}
