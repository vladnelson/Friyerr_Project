package com.example.friyerr_mobile.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.example.friyerr_mobile.view.ui.ViewHolder.AccomodationVH
import com.squareup.picasso.Picasso
import java.util.ArrayList

class ListAccomondationAdapter(private  var acitivity: FragmentActivity?, private var listAccommondatation: ArrayList<Accommodation>, private  var context: Context?, private  val listener: OnItemClickListenerList<Accommodation>)  : RecyclerView.Adapter<AccomodationVH>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AccomodationVH {
        var inflater : LayoutInflater =  LayoutInflater.from(p0.context)
        var view: View = inflater.inflate(R.layout.listresult_layout,p0,false)

        return AccomodationVH(view, context)
    }

    override fun getItemCount(): Int {
      return listAccommondatation.size
    }

    override fun onBindViewHolder(p0: AccomodationVH, p1: Int)  {
        var pair : Accommodation = listAccommondatation[p1]
        p0.LoadView(pair, listener)
    }
}






