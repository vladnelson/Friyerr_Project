package com.example.friyerr_mobile.view.ui.ViewHolder

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.IViewHolderAdapter
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.squareup.picasso.Picasso

class AccomodationVH (itemview  : View, _context: Context?): RecyclerView.ViewHolder(itemview) ,IViewHolderAdapter<Accommodation>{

        var _accomodation : Accommodation? =  null
        var ImgAcommodation : ImageView
        var TxtNameAcommondation  : TextView
        var ImgBtnLike : ImageButton
        var RatingAccommandation : RatingBar
        var TxtRateAndCityAcommandation: TextView
        var _Context :  Context?

        init {
            this._Context =_context
            this.ImgAcommodation=itemview.findViewById(R.id.ImgResultForResultSearch)
            this.TxtNameAcommondation=itemview.findViewById(R.id.TxtNameResultForResultSearch)
            this.ImgBtnLike=itemview.findViewById(R.id.ImgBtnLikeForResultSearch)
            this.RatingAccommandation=itemview.findViewById(R.id.RtbRatingSearchForResultSearch)
            this.TxtRateAndCityAcommandation = itemview.findViewById(R.id.TxtRateAndVilleViewForResultSearch)
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
                    ItemAccomodation.typeLocation

            // ----------------------------------------------------------------
            // Changement des likes
            // ----------------------------------------------------------------
            if (ItemAccomodation.isLike){
                ImgBtnLike.setImageResource(R.drawable.ic_favorite_yes_24dp)
            }else{
                ImgBtnLike.setImageResource(R.drawable.ic_favorite_no_24dp)
            }

            // ----------------------------------------------------------------
            // Changement rating
            // ----------------------------------------------------------------
            RatingAccommandation.rating=ItemAccomodation.rate

            // ----------------------------------------------------------------
            // Chargement des villes
            // ----------------------------------------------------------------
            TxtRateAndCityAcommandation.text=""+ItemAccomodation.rate +"/5.0 * "+ItemAccomodation.city

            itemView.setOnClickListener {
                listener.onItemClick(ItemAccomodation)
            }
        }
}