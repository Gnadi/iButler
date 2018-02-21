package at.codingpanda.ibutler.app

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.R.attr.fragment
import android.support.annotation.NonNull
import android.view.MenuItem
import android.view.View
import com.google.android.gms.maps.*


class MainActivity : FragmentActivity(),OnMapReadyCallback {



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .replace(R.id.frame_layout,HomeFragment().newInstance())
                        .commit()
                toggleMap(true)
                //inflateNewJob(true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                //toggleMap(false)
                //fragmentManager.executePendingTransactions()
                //inflateNewJob(false)
                toggleMap(false)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                toggleMap(true)
                //inflateNewJob(false)
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .replace(R.id.frame_layout,HomeFragment().newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.frame_layout,HomeFragment().newInstance())
                .commit()
        toggleMap(true)

        val mapFragment = fragmentManager
                .findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)

    }
    override fun onMapReady(googleMap: GoogleMap) {
        val sydney = LatLng(-33.852, 151.211)
        googleMap.addMarker(MarkerOptions().position(sydney)
                .title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


    fun toggleMap(toggle:Boolean){

        val mapFragment = fragmentManager
                .findFragmentById(R.id.map) as MapFragment
        if(toggle)
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .hide(mapFragment)
                    .commit()
        else
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(mapFragment)
                    .commit()
    }

    /*fun inflateNewJob(toggle:Boolean){
        if (toggle) {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.your_placeholder, BlankFragment())
            ft.commit()
        } else {
            val ft = supportFragmentManager.beginTransaction()
            ft.hide(BlankFragment())
            ft.commit()
        }

    }*/
}

