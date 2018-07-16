package com.sidecarhealth.sidecarhealth.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidecarhealth.sidecarhealth.R
import kotlinx.android.synthetic.main.fragment_overview.*


/**
 * Created by romanedjlali on 7/15/18.
 */


class OverviewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_overview, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_dir.setOnClickListener(View.OnClickListener { view ->
            //Just for test
            /*Snackbar.make(view, "Here's a direction", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/
            Handler().postDelayed(Runnable {
                val gmmIntentUri = Uri.parse("geo:0,0?q=")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.`package` = "com.google.android.apps.maps"
                startActivity(mapIntent)
            }, 1000)

        })

        fab_handset.setOnClickListener(View.OnClickListener { view ->
            //just for test
            /*Snackbar.make(view, "Here's a Dialer", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/

            /** Creating an intent with the dialer's action name  */
            /** Since the intent is created with activity's action name, the intent is an implicit intent */
            val intent = Intent("android.intent.action.DIAL")

            /** Starting the Dialer activity */
            startActivity(intent)
        })

    }

    companion object {
        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }

}
