package com.sidecarhealth.sidecarhealth.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidecarhealth.sidecarhealth.R
import kotlinx.android.synthetic.main.single_card.view.*

/**
 * Created by romanedjlali on 7/15/18.
 */

class DoctorCostAdapter(val doctorCosts : List<DoctorCost>)  : RecyclerView.Adapter<DoctorCostAdapter.DrCostViewHolder>()    //Constructor of the class
{

    class DrCostViewHolder(val card: View) : RecyclerView.ViewHolder(card) //VieHolder in RV is responsible for minimizing to call to findViewById

    //Create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DrCostViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.single_card, parent, false)
        return DrCostViewHolder(view)
    }

    //Specifies the contents for the shown DrCost, Bind elements of cardview
    override fun onBindViewHolder(holder: DrCostViewHolder?, index: Int) {
        if (holder!=null) {
            val doctorCost = doctorCosts[index]
            holder.card.tv_title.text = doctorCost.title
            holder.card.tv_description.text = doctorCost.description
            holder.card.iv_icon.setImageResource(doctorCost.image)
        }
    }

    override fun getItemCount() = doctorCosts.size
}