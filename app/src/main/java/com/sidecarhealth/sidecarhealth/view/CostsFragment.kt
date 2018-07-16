package com.sidecarhealth.sidecarhealth.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidecarhealth.sidecarhealth.R
import com.sidecarhealth.sidecarhealth.util.DoctorCostAdapter
import com.sidecarhealth.sidecarhealth.util.getSampleDoctorCosts
import kotlinx.android.synthetic.main.fragment_costs.*


/**
 * Created by romanedjlali on 7/15/18.
 */


class CostsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_costs,container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Adapter -> defines data
        //RecycleView -> implement 3 methods
        rv.setHasFixedSize(true) //size of each card & content is constant and not change when new item added or removed

        rv.layoutManager = LinearLayoutManager(activity)// use lineare layout manager
        rv.adapter = DoctorCostAdapter(getSampleDoctorCosts())

        /*iv_icon.setImageResource(R.drawable.ic_doctor_32)
        tv_title.text = getString(R.string.cardview_title)
        tv_description.text = getString(R.string.cardview_description)*/
    }
}