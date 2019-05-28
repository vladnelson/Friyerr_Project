package com.example.friyerr_mobile.view.ui.Fragment

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.fragment_search_type_period.*
import java.util.*


class SearchTypePeriodFragment : Fragment() {
    companion object {
        val TAG :String ="SearchTypePeriod"
    }

    var mDateSetListener :  DatePickerDialog.OnDateSetListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_type_period, container, false)

        var btnNextForSearchPeriod = rootView.findViewById<Button>(R.id.BtnNextForSearchPeriod)
        var imgReturnForSearchPeriod=rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchPeriode)
        var editStartForSearchTypePeriod =rootView.findViewById<TextView>(R.id.EditStartForSearchTypePeriod)
        var editEndForSearchTypePeriod= rootView.findViewById<TextView>(R.id.EditEndForSearchTypePeriod)


        btnNextForSearchPeriod.setOnClickListener{
            val childFragment = SearchResultFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchResultFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(
                TAG
            )?.commit()
        }


        imgReturnForSearchPeriod.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        editStartForSearchTypePeriod.setOnClickListener{
            var cal : Calendar = Calendar.getInstance()
            var year :Int =  cal.get(Calendar.YEAR)
            var month :Int =  cal.get(Calendar.MONTH)
            var day :Int =  cal.get(Calendar.DAY_OF_MONTH)

            var dialog : DatePickerDialog =  DatePickerDialog(this.context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day)

            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
        editEndForSearchTypePeriod.setOnClickListener{
            var cal : Calendar = Calendar.getInstance()
            var year :Int =  cal.get(Calendar.YEAR)
            var month :Int =  cal.get(Calendar.MONTH)
            var day :Int =  cal.get(Calendar.DAY_OF_MONTH)

            var dialog : DatePickerDialog =  DatePickerDialog(this.context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day)

            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        mDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            var   m=month+1
            Log.d(TAG,"On date Set : date " + dayOfMonth+ "/"+m+"/"+year)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BtnNextForSearchPeriod.setOnClickListener{
            val childFragment = SearchResultFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.containterSearch,childFragment,SearchResultFragment.TAG)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(
                TAG
            )?.commit()
        }


        ImgReturnForSearchPeriode.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        EditStartForSearchTypePeriod.setOnClickListener{
            var cal : Calendar = Calendar.getInstance()
            var year :Int =  cal.get(Calendar.YEAR)
            var month :Int =  cal.get(Calendar.MONTH)
            var day :Int =  cal.get(Calendar.DAY_OF_MONTH)

            var dialog : DatePickerDialog =  DatePickerDialog(this.context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day)

            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
        EditEndForSearchTypePeriod.setOnClickListener{
            var cal : Calendar = Calendar.getInstance()
            var year :Int =  cal.get(Calendar.YEAR)
            var month :Int =  cal.get(Calendar.MONTH)
            var day :Int =  cal.get(Calendar.DAY_OF_MONTH)

            var dialog : DatePickerDialog =  DatePickerDialog(this.context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day)

            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        mDateSetListener =object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
               var   m=month+1
                Log.d(TAG,"On date Set : date " + dayOfMonth+ "/"+m+"/"+year)
            }

        }

    }


}
