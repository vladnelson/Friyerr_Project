package com.example.friyerr_mobile.view.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Town
import com.example.friyerr_mobile.view.ui.ViewHolder.TownVH


class ListTownAdapter(private  var acitivity: FragmentActivity?, private var listTown: ArrayList<Town>, private  var context: Context?, private  val listener: OnItemClickListenerList<Town>)  : RecyclerView.Adapter<TownVH>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TownVH {
        var inflater : LayoutInflater =  LayoutInflater.from(p0.context)
        var view: View = inflater.inflate(R.layout.listcity_layout,p0,false)

        return TownVH(view, context)
    }
    override fun onBindViewHolder(p0: TownVH, p1: Int) {
        var pair : Town = listTown[p1]
        p0.LoadView(pair, listener)
    }

    override fun getItemCount(): Int {
        return listTown.size
    }


}





