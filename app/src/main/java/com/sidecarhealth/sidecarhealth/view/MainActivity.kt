package com.sidecarhealth.sidecarhealth.view

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.sidecarhealth.sidecarhealth.R
import com.sidecarhealth.sidecarhealth.services.SidecarHealthServiceProvider

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].//We use this if we have dynamic tabs otherwise using: [android.support.v4.app.FragmentPagerAdapter]
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        viewpager_container.adapter = mSectionsPagerAdapter

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/

        val fragmentAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewpager_container.adapter = fragmentAdapter

        tablayout.setupWithViewPager(viewpager_container)


        var address = requestDoctorInfo(12345);

        requestDoctorVisitationCost(12345)
    }

    private fun requestDoctorInfo(id:Int){
        var sidecarHealthServiceProvider = SidecarHealthServiceProvider()
        sidecarHealthServiceProvider.getDoctorInfo(id);
    }

    private fun requestDoctorVisitationCost(id:Int){
        var sidecarHealthServiceProvider = SidecarHealthServiceProvider()
        sidecarHealthServiceProvider.getVisitationCost(id)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {

                0 -> return OverviewFragment()
                1 -> return CostsFragment()
                else -> return null
            }
        }

        override fun getCount(): Int {
            // Show 2 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Overview"
                1 -> return "Costs"
            }
            return null
        }

    }
}
