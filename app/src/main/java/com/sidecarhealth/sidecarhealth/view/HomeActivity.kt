package com.sidecarhealth.sidecarhealth.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidecarhealth.sidecarhealth.R

/**
 * Created by romanedjlali on 7/15/18.
 */

class HomeActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home,container, false)
    }
}