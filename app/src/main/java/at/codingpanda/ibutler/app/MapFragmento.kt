package at.codingpanda.ibutler.app

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment




class MapFragmento: MapFragment(), OnMapReadyCallback {

    public fun newInstance(): MapFragmento {
        return MapFragmento()
    }
    // Include the OnCreate() method here too, as described above.
    override fun onMapReady(googleMap: GoogleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        val sydney = LatLng(-33.852, 151.211)
        googleMap.addMarker(MarkerOptions().position(sydney)
                .title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle): View {
        return inflater.inflate(R.id.map, container, false)
    }
}