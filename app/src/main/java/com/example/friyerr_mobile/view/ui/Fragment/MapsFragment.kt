package com.example.friyerr_mobile.view.ui.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.friyerr_mobile.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsFragment :
    Fragment(),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mMapView: MapView

    val ZOOM_LEVEL = 16f

    companion object {
        val TAG: String = "MapsActitivy"
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
*/
    private lateinit var mSupportMapFragment: SupportMapFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.activity_maps, container, false)


        Log.d(TAG, "Creation du fragment")

        // var mRecyclerView = mSupportMapFragment.(R.id.ListResultSearch)
        //val mapFragment = fragmentManager?.findFragmentById(R.id.map) as SupportMapFragment
        // mapFragment.getMapAsync(this)
        var mapFragment = map as SupportMapFragment?

        if (mapFragment != null) {
            mapFragment.getMapAsync(this)
        }
        return view
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(48.967232, 2.3619887)
        mMap.addMarker(
            MarkerOptions().position(sydney).title("Home")
                .snippet("Facebook HQ : Menlo Park")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_localisation_now))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, ZOOM_LEVEL))

    }
}
