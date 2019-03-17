package com.example.friyerr_mobile

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.util.ArrayList


class CustomListview(private  var acitivity: FragmentActivity?, private var listCity: ArrayList<city>, private  var context: Context?)  : RecyclerView.Adapter<ViewHolder>()
{
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var pair :city  = listCity.get(p1)
        p0.display(pair)
    }

    override fun getItemCount(): Int {
        return listCity.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var inflater : LayoutInflater =  LayoutInflater.from(p0.context)
        var view: View = inflater.inflate(R.layout.listcity_layout,p0,false)
        return ViewHolder(view,context)
    }
}
class  ViewHolder(itemview  : View, _context: Context?): RecyclerView.ViewHolder(itemview){

    var _city :city? =  null
    var txtCity : TextView? =  null
    var PlaceCity  : ConstraintLayout
    var _Context :  Context?

    init {
        this._Context =_context
        this.txtCity=itemview.findViewById(R.id.TxtCityView)
        this.PlaceCity=itemview.findViewById(R.id.ConstraintCity)
    }

    fun  display( pair :city) {
        _city = pair
        txtCity?.text=pair.nameCity

        var custumLayout:CustomLayout = CustomLayout(PlaceCity,PlaceCity.resources)

        Picasso.with(this._Context).load(pair.uRLCity)
            .into(custumLayout)
    }
}





//override fun getItem(position: Int): Int {
//      return  position
// }

//override fun getItemId(position: Int): Long {
//  return  position.toLong()
//}

//override fun getCount(): Int {
//  return listCity.size
//}



class city(name : String , Url : String ) {
    var nameCity : String
    var uRLCity: String
    init {
        this.nameCity=name
        this.uRLCity=Url
    }
}


class CustomLayout(private var view: ConstraintLayout, private   var res : Resources) : Target {

    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

    }

    override fun onBitmapFailed(errorDrawable: Drawable?) {

    }

    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        view.background= BitmapDrawable(res,bitmap)
    }
}



