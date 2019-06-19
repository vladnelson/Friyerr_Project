package com.example.friyerr_mobile.view.ui.ViewHolder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.IViewHolderAdapter
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Town
import com.squareup.picasso.Picasso

class TownVH(itemview  : View, _context: Context?): RecyclerView.ViewHolder(itemview) , IViewHolderAdapter<Town> {
        var _town : Town? =  null
        var txtCity : TextView? =  null
        var PlaceCity  : ImageView
        var _Context :  Context?

        init {
            this._Context =_context
            this.txtCity=itemview.findViewById(R.id.TxtCityView)
            this.PlaceCity=itemview.findViewById(R.id.ImgSearchCountry)
        }

        override  fun  LoadView(aTown : Town, ActionClick: OnItemClickListenerList<Town>) {
            _town = aTown

            //----------------------------------------------------------------------
            // Chargement du nom de la ville dans la vue
            //----------------------------------------------------------------------
            txtCity?.text=aTown.nameCity

            //----------------------------------------------------------------------
            // Chargement de l'image de fond dans un imageview
            //----------------------------------------------------------------------
            Picasso.with(this._Context).load(aTown.uRLCity)
                .into(PlaceCity)

            //----------------------------------------------------------------------
            // Chargement de l'évenement OnItemClick
            //----------------------------------------------------------------------
            itemView.setOnClickListener {
                ActionClick.onItemClick(aTown)
            }
        }
}

