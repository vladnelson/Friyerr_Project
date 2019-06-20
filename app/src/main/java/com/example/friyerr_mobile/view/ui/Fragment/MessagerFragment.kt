package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.friyerr_mobile.R

class MessagerFragment : Fragment() {

    private  var transaction : FragmentTransaction?  = null
    companion object {
        val TAG :String ="MessagerFragment"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_messager, container, false)
        val childFragment = SearchTypeFragment()
        //transaction = childFragmentManager.beginTransaction()
        //transaction?.replace(R.id.containterSearch, childFragment,SearchTypeFragment.TAG)?.addToBackStack(null)?.commit()
        return rootView
    }
}