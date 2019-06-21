package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.RequestApi.GetRequestIdentity
import com.example.friyerr_mobile.service.RequestApi.PostRequestLogout
import com.example.friyerr_mobile.service.model.User
import com.example.friyerr_mobile.view.adapter.CircleTransform
import com.example.friyerr_mobile.view.adapter.ViewPagerAdapter
import com.example.friyerr_mobile.view.ui.activity.PresentationActivity
import com.example.friyerr_mobile.viewmodel.Profil.TokenVM
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation


class ProfileFragment : Fragment()  {
    private  var transaction : FragmentTransaction?  = null
    companion object {
        val TAG : String = "ProfileFragment"
    }

    private val tabIcons = intArrayOf(R.drawable.ic_action_globe, R.drawable.ic_action_globe)

    private var isImageFitToScren=true
private  var ImageProfile :ImageView? = null
    private  var FullNameTxtProfile :TextView? = null
    private  var PseudoTxtProfile :TextView? = null
    private  var CityTxtProfile :TextView? = null
    private  var NotificationTxtProfile : TextView? =  null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        Log.d(TAG,"Je suis dans profile")
        //var viewPager = rootView.findViewById<ViewPager>(R.id.containterFavorite)
      //  var tabLayout =  rootView.findViewById<TabLayout>(R.id.tabs)
         ImageProfile  =  rootView.findViewById<ImageView>(R.id.ImgProfile)
         FullNameTxtProfile  =  rootView.findViewById<TextView>(R.id.TxtFullNameProfile)
        PseudoTxtProfile  =  rootView.findViewById<TextView>(R.id.TxtPseudoForProfile)
        NotificationTxtProfile = rootView.findViewById<TextView>(R.id.badge_notification_Profile)
        CityTxtProfile = rootView.findViewById<TextView>(R.id.TxtCityForProfile)

        GetRequestIdentity(this.activity!!, TAG).execute()


        //setUpViewPager(viewPager)


        //viewPager.currentItem = 0

        //tabLayout.setupWithViewPager(viewPager)
        var mBtnLogoutForInformation = rootView.findViewById<LinearLayout>(R.id.BtnLogoutForInformation)
        var ImgProfile = rootView.findViewById<ImageView>(R.id.ImgProfile)

        mBtnLogoutForInformation.setOnClickListener {
            mBtnLogoutForInformation.isClickable = false
            PostRequestLogout(rootView,activity).execute()

        }


        ImgProfile.setOnClickListener {
            if(isImageFitToScren){
                isImageFitToScren=false
                ImgProfile.setLayoutParams(
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                )
                ImgProfile.setAdjustViewBounds(true)
            }else{
                isImageFitToScren=true
                ImgProfile.setLayoutParams(
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                )
                ImgProfile.setScaleType(ImageView.ScaleType.FIT_XY)
            }
        }
//if (eed.)



        //val childFragment = this
        //transaction = childFragmentManager.beginTransaction()
        //transaction?.replace(R.id.containterFavorite, childFragment,ProfileFragment.TAG)?.addToBackStack(null)?.commit()
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sharedPreference = this.activity!!.getSharedPreferences(
            PresentationActivity.PreferenceName,
            android.content.Context.MODE_PRIVATE
        )
        var UserIdentity :String? = sharedPreference.getString(PresentationActivity.PreferenceUser,null)


        if(UserIdentity !=  null){


            Log.d(TAG,UserIdentity)


            var json = Gson()
            var   response = json.fromJson(UserIdentity, User::class.java)



            FullNameTxtProfile!!.text= response.Name+" "+response.Firstname
            PseudoTxtProfile!!.text="@LOVE_LOVE"
            NotificationTxtProfile!!.text=" 0 "
            CityTxtProfile!!.text="LONDRES"+", "+"ANGLETERRE"
            Picasso.with(this.activity)
                .load(response.Picture_Url)
               .transform(CircleTransform())
                //.load("https://heritagevillagecincinnati.org/wp-content/uploads/2017/12/icon.png")
                .into(ImageProfile)



        }


    }


/*
    private fun setUpViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(fragmentManager)
        adapter.addFragment(FavoriteSportsFragment(), "FAVORITE SPOTS")
     //   adapter.addFragment(InformationFragment(), "INFORMATIONS")
        viewPager.adapter = adapter
    }
    */
}
