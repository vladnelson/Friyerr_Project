package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.friyerr_mobile.view.adapter.ListAccomondationAdapter
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.example.friyerr_mobile.service.model.Flat
import com.example.friyerr_mobile.service.model.House
import kotlinx.android.synthetic.main.fragment_search_result.*


class SearchResultFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        val TAG: String = "SearchResult"
    }

    private var mSwipeRefreshLayout:SwipeRefreshLayout?= null
    private var mRecyclerView:RecyclerView?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_search_result, container, false)
        var mRecyclerView = rootView.findViewById<RecyclerView>(R.id.ListResultSearch)

        //----------------------------------------------------------------
        // Chargement des données
        //----------------------------------------------------------------
        ChargeAccomondation(mRecyclerView)

        var mImgReturnForSearchResult = rootView.findViewById<ImageButton>(R.id.ImgReturnForSearchResult)
        mImgReturnForSearchResult.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        //-----------------------------------------------------------------------------------------
        //  Initalisation du Refresh View
        //-----------------------------------------------------------------------------------------
         mSwipeRefreshLayout = rootView.findViewById<SwipeRefreshLayout>(R.id.RefreshPage)
        mSwipeRefreshLayout?.setOnRefreshListener(this)
        mSwipeRefreshLayout?.setColorSchemeResources(
            R.color.colorPrimary,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark
        )

        return rootView
    }

    override fun onRefresh() {
        ChargeAccomondation(mRecyclerView)
        mSwipeRefreshLayout!!.isRefreshing = false
    }


    private fun ChargeAccomondation(ListAccomondation: RecyclerView?) {
        var AccommodationList: ArrayList<Accommodation> = ArrayList<Accommodation>()
        AccommodationList.add(
            Flat(
                "",
                "colocation",
                "Flat",
                22.0.toFloat(),
                4.2.toFloat(),
                "62 rue de paris",
                750018,
                "PARIS",
                "FRANCE",
                "Super appartement",
                3,
                1,
                "https://q-xx.bstatic.com/images/hotel/max400/626/62668201.jpg",
                false,
                0F,
                0F
            )
        )
        AccommodationList.add(
            Flat(
                "",
                "colocation",
                "Flat",
                54.0.toFloat(),
                4.2.toFloat(),
                "62 rue de paris",
                750010,
                "PARIS",
                "FRANCE",
                "Super appartement",
                5,
                3,
                "https://q-xx.bstatic.com/images/hotel/max400/109/109054263.jpg",
                true,
                0F,
                0F
            )
        )
        AccommodationList.add(
            House(
                "",
                "location",
                "House",
                120.0.toFloat(),
                3.2.toFloat(),
                "62 rue de paris",
                750010,
                "PARIS",
                "FRANCE",
                "Super appartement",
                3,
                2,
                "https://docs.plans-constructeurs-maisons.fr/MaisonsFranceConfort/1144612/des-maisons-de-plain-pied-a-prix-maitrises.jpg",
                true,
                0F,
                0F
            )
        )

        ListAccomondation?.layoutManager = LinearLayoutManager(context)
        ListAccomondation?.adapter = ListAccomondationAdapter(
            this.activity,
            AccommodationList,
            context,
            object :
                OnItemClickListenerList<Accommodation> {
                override fun onItemClick(item: Accommodation) {
                    openActionClickItem()
                }
            }
        )

    }


    fun openActionClickItem() {
        // Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
        val childFragment = AccommodationDetailFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.containterSearch, childFragment, AccommodationDetailFragment.TAG)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()
    }

}
