package com.example.friyerr_mobile.view.ui.ViewHolder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.IViewHolderAdapter
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.squareup.picasso.Picasso

class AccomodationFavoriteVH (itemview  : View, _context: Context?): RecyclerView.ViewHolder(itemview) ,
    IViewHolderAdapter<Accommodation>
{
    var _accomodation : Accommodation? =  null
    var ImgAcommodation : ImageView
    var TxtNameAcommondation  : TextView
    var RatingAccommandation : RatingBar
    var TxtRateAndCityAcommandation: TextView
    var _Context :  Context?

    init {
        this._Context =_context
        this.ImgAcommodation=itemview.findViewById(R.id.ImgResultForAccomodationFavorite)
        this.TxtNameAcommondation=itemview.findViewById(R.id.TxtNameResultForAccomodationFavorite)
        this.RatingAccommandation=itemview.findViewById(R.id.RtbRatingSearchForAccomodationFavorite)
        this.TxtRateAndCityAcommandation = itemview.findViewById(R.id.TxtRateAndVilleViewForAccomodationFavorite)
    }

    override fun  LoadView(ItemAccomodation : Accommodation, listener: OnItemClickListenerList<Accommodation>) {
        _accomodation = ItemAccomodation

        // ----------------------------------------------------------------
        // Changement des images des Appartements
        // ----------------------------------------------------------------
        Picasso.with(this._Context).load(ItemAccomodation.urlImage)
            .into(this.ImgAcommodation)

        // ----------------------------------------------------------------
        // Chargment du text
        // ----------------------------------------------------------------
        TxtNameAcommondation.text=
            ItemAccomodation.typeAccomodation+ " "+
                    ItemAccomodation.suraface+"m², "+
                    ItemAccomodation.city

        // ----------------------------------------------------------------
        // Changement rating
        // ----------------------------------------------------------------
        RatingAccommandation.rating=ItemAccomodation.rate

        // ----------------------------------------------------------------
        // Chargement des villes
        // ----------------------------------------------------------------
        TxtRateAndCityAcommandation.text=""+ItemAccomodation.rate +"/5.0"

        itemView.setOnClickListener {
            listener.onItemClick(ItemAccomodation)
        }
    }
}