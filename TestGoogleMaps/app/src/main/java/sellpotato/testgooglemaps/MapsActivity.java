package sellpotato.testgooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static final LatLng terminal = new LatLng(-20.227857,-70.131729);
    private static final PolylineOptions rutas = new PolylineOptions().add(terminal).add(new LatLng(-20.23995711223462,-70.14002591371536));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        Bundle b = getIntent().getExtras();
        Posicion a = (Posicion)b.getSerializable("waypoint");
        LatLng punto = new LatLng(a.getLatitud(),a.getLongitud());
        setMarker(a.getDireccion(),punto);
        //setMarker("Terminal",terminal);
        drawLine(rutas);
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {

                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                //mMap.setMyLocationEnabled(true);

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminal,15f));

            }
        }
    }

    private void setMarker(String title, LatLng position)
    {
        Marker myMaker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(title)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }

    private void drawLine(PolylineOptions op)
    {
        Polyline polyline = mMap.addPolyline(op);
    }
}
