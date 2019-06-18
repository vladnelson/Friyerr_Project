package com.example.friyerr_mobile.view.ui.Fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Town
import kotlinx.android.synthetic.main.fragment_search_type_price.*

class SearchTypePriceFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypePrice"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type_price, container, false)
        var btnNextforSearchPrice=rootView.findViewById<Button>(R.id.BtnNextForSearchPrice)
        var imgReturnForSearchPrice=rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchPrice)

        var RangeSeek =rootView.findViewById<CrystalRangeSeekbar>(R.id.RangePriceDouble)
        var TxtMinPrice =rootView.findViewById<TextView>(R.id.PriceRangeMinForSearchTypePrice)
        var TxtMaxPrice =rootView.findViewById<TextView>(R.id.PriceRangeMaxForSearchTypePrice)

        RangeSeek.setOnRangeSeekbarChangeListener(object :
            OnRangeSeekbarFinalValueListener, OnRangeSeekbarChangeListener {
            override fun finalValue(minValue: Number?, maxValue: Number?) {
                TxtMinPrice.text = minValue.toString() + " €"
                TxtMaxPrice.text = maxValue.toString() + " €"
            }

            override fun valueChanged(minValue: Number?, maxValue: Number?) {
                TxtMinPrice.text = minValue.toString() + " €"

                if(Integer.parseInt(maxValue.toString())<1000){
                    TxtMaxPrice.text = maxValue.toString() + " €"
                }else{
                    TxtMaxPrice.text = "+ 1000 €"
                }

            }

        })

        btnNextforSearchPrice.setOnClickListener{
            val childFragment = SearchTypePeriodFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchTypePeriodFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
        }

        imgReturnForSearchPrice.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        return rootView
    }
}
