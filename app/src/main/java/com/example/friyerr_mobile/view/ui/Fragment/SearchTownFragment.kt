package com.example.friyerr_mobile.view.ui.Fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.`interface`.OnItemClickListenerList
import com.example.friyerr_mobile.service.model.Town
import com.example.friyerr_mobile.view.adapter.ListTownAdapter
import com.example.friyerr_mobile.view.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_town.*


class SearchTownFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        val TAG: String = "SearchTown"
        var progres = 50
    }

    private var mRecyclerView: RecyclerView? = null
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView = inflater.inflate(R.layout.fragment_town, container, false)


        mRecyclerView = rootView.findViewById(R.id.ListCity)
        ChargeTown(mRecyclerView!!)
        var mImgReturnForFragmenttown = rootView.findViewById<ImageButton>(R.id.ImgReturnForFragmenttown)
        mImgReturnForFragmenttown.setOnClickListener {
            fragmentManager?.popBackStack()
        }


        var PGRTown =  rootView.findViewById<ProgressBar>(R.id.ProgressbarForTown)

        var obj : ObjectAnimator = ObjectAnimator.ofInt(PGRTown,"progress",
            MainActivity.CompteurStateOld,
            progres
        )
        obj.duration=500
        obj.interpolator= LinearInterpolator()
        obj.start()
        MainActivity.CompteurStateOld= progres

        mSwipeRefreshLayout = rootView.findViewById(R.id.SRLTown)
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
        ChargeTown(mRecyclerView!!)
        mSwipeRefreshLayout?.isRefreshing = false
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)

          ChargeTown(ListCity)
          ImgReturnForFragmenttown.setOnClickListener{
              fragmentManager?.popBackStack()
          }
      }*/
    private fun ChargeTown(listCity: RecyclerView) {
        var townList: ArrayList<Town> = ArrayList<Town>()
        townList.add(
            Town(
                "BORDEAUX",
                "https://www.deepki.com/wp-content/uploads/2017/02/ville-de-paris.jpg"
            )
        )
        townList.add(
            Town(
                "PARIS",
                "https://www.telegraph.co.uk/travel/destination/article130148.ece/ALTERNATES/w620/parisguidetower.jpg"
            )
        )
        townList.add(
            Town(
                "TOULOUSE",
                "https://img.fotocommunity.com/vue-sur-le-pont-neuf-et-le-centre-ville-de-toulouse-la-ville-rose-a7fd587d-fd2f-442f-b57d-b84797040e26.jpg?height=1080"
            )
        )
        townList.add(
            Town(
                "MONTPELLIER",
                "https://www.montpellier.fr/uploads/Image/70/29354_083_banner-ville-Montpellier.jpg"
            )
        )
        townList.add(
            Town(
                "ROUEN",
                "https://www.rouentourisme.com/wp-content/uploads/2016/08/slide-1-journ%C3%A9e-%C3%A0-rouen.jpg"
            )
        )

        listCity.layoutManager = LinearLayoutManager(context)
        listCity.adapter = ListTownAdapter(
            this.activity,
            townList,
            context,
            object :
                OnItemClickListenerList<Town> {
                override fun onItemClick(item: Town) {
                    openActionClickItem()
                }
            }
        )

    }

    fun openActionClickItem() {
        // Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
        val childFragment = SearchTypePriceFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.containterSearch, childFragment, SearchTypePriceFragment.TAG)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)?.addToBackStack(TAG)?.commit()

    }
}
