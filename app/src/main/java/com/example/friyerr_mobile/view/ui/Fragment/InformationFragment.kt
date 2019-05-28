package com.example.friyerr_mobile.view.ui.Fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.RequestApi.PostRequestLogout
import kotlinx.android.synthetic.main.fragment_information.*


class InformationFragment : Fragment() {
    companion object {
        val TAG: String = "InformationFragment"
    }
     var  mContext:Context?=null
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext=context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_information, container, false)
        var mBtnLogoutForInformation = rootView.findViewById<LinearLayout>(R.id.BtnLogoutForInformation)

        mBtnLogoutForInformation.setOnClickListener {
            mBtnLogoutForInformation.isClickable = false
            PostRequestLogout(rootView,activity).execute()

        }

        return rootView
    }
}
