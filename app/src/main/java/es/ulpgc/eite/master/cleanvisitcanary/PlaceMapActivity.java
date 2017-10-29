package es.ulpgc.eite.master.cleanvisitcanary;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceMapActivity extends BaseActivity implements OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    //private PlaceStore placeStore;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillPlaceStoreFromResources();
        setupUI();
        //setupLocationManager();
    }
    */

    private void setupLocationManager(final GoogleMap googleMap) {
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //String locationProvider = LocationManager.NETWORK_PROVIDER;
        String locationProvider = LocationManager.GPS_PROVIDER;


        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                Log.d("MAP", "location=" +  location);

                //currentLocation = location;
                googleMap.clear();
                displayLocation(googleMap, location);
                displayPlaces(googleMap);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        // Register the listener with the Location Manager to receive location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            // ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            // public void onRequestPermissionsResult(
            //       int requestCode, String[] permissions, int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);

    }

    @Override
    protected void setupUI() {
        setContentView(R.layout.activity_place_map_main);

        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_map));
        }

        // Obtain the Map Fragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /*
    private void setupUI() {
        setContentView(R.layout.activity_place_map_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_map));
        }

        // Obtain the Map Fragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    */


    /*

    private void setupUI() {
        setContentView(R.layout.activity_place_map);

        setupToolbar();

        // Obtain the Map Fragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle(getTitle());

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_map));
        }

    }
    */


    /*
    private void fillPlaceStoreFromResources() {
        Resources res = getResources();
        List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
        List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
        List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));
        List<String> locations = Arrays.asList(res.getStringArray(R.array.places_locations));

        placeStore = new PlaceStore(titles, details, pictures, locations);
    }
    */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //googleMap.setOnMarkerClickListener(MainMapActivity.this);
        googleMap.setOnInfoWindowClickListener(PlaceMapActivity.this);
        displayPlaces(googleMap);

        setupLocationManager(googleMap);


        /*
        // Add all markers and move the camera
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Place place : placeStore.getPlaces()) {

            try {

                String[] locations = place.location.split(",");
                double latitude = Double.parseDouble(locations[0]);
                double longitude = Double.parseDouble(locations[1]);
                LatLng location = new LatLng(latitude, longitude);
                MarkerOptions marker = new MarkerOptions().position(location)
                    .title(place.title)
                    .snippet(place.id);
                googleMap.addMarker(marker);
                builder.include(marker.getPosition());

            } catch (Exception error) {
                //Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }




        if(!placeStore.getPlaces().isEmpty()){

            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen

            CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            googleMap.moveCamera(camera);
            //googleMap.animateCamera(camera);
        }
        */
    }

    private void displayPlaces(GoogleMap googleMap){

        // Add all markers and move the camera
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Place place : placeStore.getPlaces()) {

            try {

                String[] locations = place.location.split(",");
                double latitude = Double.parseDouble(locations[0]);
                double longitude = Double.parseDouble(locations[1]);
                LatLng location = new LatLng(latitude, longitude);
                MarkerOptions marker = new MarkerOptions().position(location)
                        .title(place.title)
                        .snippet(place.id);
                googleMap.addMarker(marker);
                builder.include(marker.getPosition());

            } catch (Exception error) {
                //Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }




        if(!placeStore.getPlaces().isEmpty()){

            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen

            CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            googleMap.moveCamera(camera);
            //googleMap.animateCamera(camera);
        }
    }

    private void displayLocation(GoogleMap googleMap, Location location){
        if (location == null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                return;
            }

            /*
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
            if (lastKnownLocation != null) {
                location = lastKnownLocation;
            }
            */
        }

        if (location != null) {
            LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions myMarker = new MarkerOptions().position(myLocation)
                .title("Current Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            googleMap.addMarker(myMarker);
            //builder.include(myMarker.getPosition());
        }
    }

    /*
    private void goToPlaceDetails(String placeId ) {
        Intent intent = new Intent(PlaceMapActivity.this, PlaceDetailActivity.class);
        intent.putExtra(PlaceDetailActivity.PARAM_PLACE_ID, placeId);
        startActivity(intent);
    }

        private void goToPlaceList( ) {
        Intent intent = new Intent(PlaceMapActivity.this, PlaceListActivity.class);
        startActivity(intent);
        finish();
    }
    */

    @Override
    public boolean onMarkerClick(Marker marker) {
        String placeId = marker.getSnippet();
        goToPlaceDetails(placeId);

        return true;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        String placeId = marker.getSnippet();
        goToPlaceDetails(placeId);

        /*
        String title = marker.getTitle();
        Place place = placeStore.getPlaceByName(title);
        goToPlaceDetails(place.placeId);
        */
    }



    /*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    */


    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            // Handle the map action
            //goToPlaceMap();

        } else if (id == R.id.nav_list) {
            // Handle the list action
            goToPlaceList();

            //} else if (id == R.id.nav_slideshow) {


            //} else if (id == R.id.nav_share) {

            //} else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    */


    /*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_list_button) {
            goToPlaceList();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
    */
}