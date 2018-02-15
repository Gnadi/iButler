package at.codingpanda.ibutler.app

import android.annotation.SuppressLint
import android.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.MapFragment


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

    override fun getMapAsync(p0: OnMapReadyCallback?) {
        super.getMapAsync(p0)
    }
}