package com.example.friyerr_mobile.view.ui.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Accommodation
import com.example.friyerr_mobile.service.model.Flat
import com.example.friyerr_mobile.service.model.House
import com.example.friyerr_mobile.view.adapter.ListAccomondationAdapter
import com.example.friyerr_mobile.view.adapter.ListAccomondationFavoriteAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavoriteSportsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView= inflater.inflate(R.layout.fragment_favorite_sports, container, false)
        var ListAccomodation = rootView.findViewById<RecyclerView>(R.id.ListAccomondationFovorite)

        ChargeAccomondation(ListAccomodation)

        return rootView
    }

    private fun ChargeAccomondation(ListAccomondation: RecyclerView) {
        var AccommodationList :  ArrayList<Accommodation> =   ArrayList<Accommodation>()
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



        var mLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        mLayoutManager.gapStrategy=StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        ListAccomondation.setHasFixedSize(true)
        ListAccomondation.layoutManager= mLayoutManager
        ListAccomondation.adapter= ListAccomondationFavoriteAdapter(
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


    fun openActionClickItem(){
        // Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
        val childFragment = AccommodationDetailFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.containterSearch,childFragment,AccommodationDetailFragment.TAG)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(SearchResultFragment.TAG)?.commit()
    }


}
