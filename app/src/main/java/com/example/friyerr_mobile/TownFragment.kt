package com.example.friyerr_mobile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_town.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TownFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_town, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChargeTown(ListCity)
        ImgReturnForFragmenttown.setOnClickListener{
            fragmentManager?.popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    private fun ChargeTown(listCity: RecyclerView) {
        var cityList :  ArrayList<city> =   ArrayList<city>()
        cityList.add(city("BORDEAUX","https://www.deepki.com/wp-content/uploads/2017/02/ville-de-paris.jpg"))
        cityList.add(city("PARIS","https://www.deepki.com/wp-content/uploads/2017/02/ville-de-paris.jpg"))
        cityList.add(city("TOULOUSE","https://img.fotocommunity.com/vue-sur-le-pont-neuf-et-le-centre-ville-de-toulouse-la-ville-rose-a7fd587d-fd2f-442f-b57d-b84797040e26.jpg?height=1080"))
        cityList.add(city("MONTPELLIER","https://www.montpellier.fr/uploads/Image/70/29354_083_banner-ville-Montpellier.jpg"))
        cityList.add(city("ROUEN","https://www.rouentourisme.com/wp-content/uploads/2016/08/slide-1-journ%C3%A9e-%C3%A0-rouen.jpg"))

        listCity.layoutManager= LinearLayoutManager(context)
        listCity.adapter= CustomListview(this.activity,cityList,context)
    }
}
