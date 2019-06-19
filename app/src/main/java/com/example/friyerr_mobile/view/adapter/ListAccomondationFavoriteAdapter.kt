package com.example.friyerr_mobile.view.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.example.friyerr_mobile.view.ui.ViewHolder.AccomodationFavoriteVH
import com.example.friyerr_mobile.view.ui.ViewHolder.AccomodationVH
import java.util.ArrayList

class ListAccomondationFavoriteAdapter(private  var acitivity: FragmentActivity?, private var listAccommondatation: ArrayList<Accommodation>, private  var context: Context?, private  val listener: OnItemClickListenerList<Accommodation>) : RecyclerView.Adapter<AccomodationFavoriteVH>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AccomodationFavoriteVH {
        var inflater : LayoutInflater =  LayoutInflater.from(p0.context)
        var view: View = inflater.inflate(R.layout.listaccomodation_layout,p0,false)

        return AccomodationFavoriteVH(view, context)
    }

    override fun getItemCount(): Int {
        return listAccommondatation.size
    }

    override fun onBindViewHolder(p0: AccomodationFavoriteVH, p1: Int)  {
        var pair : Accommodation = listAccommondatation[p1]
        p0.LoadView(pair, listener)
    }
}