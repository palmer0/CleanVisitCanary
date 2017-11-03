package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

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
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapLocManagerViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnClickViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyViewModel;

public class PlaceMapActivity extends BaseActivity
    implements PlaceMapPresenterOutput, OnMapReadyCallback {
    /*
    implements PlaceMapPresenterOutput, OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {
    */

    //private PlaceStore placeStore;
    public PlaceMapInteractorInput interactor;
    public PlaceMapRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MediatorApi mediatorApi = (MediatorApi) getApplication();
        //placeStore = mediatorApi.getPlaceStore();

        setContentView(R.layout.activity_place_map_main);
        //setupUI();

        PlaceMapConfigurator.instance.configure(this);

        PlaceMapOnCreateRequest request = new PlaceMapOnCreateRequest(this);
        //PlaceMapOnCreateRequest request = new PlaceMapOnCreateRequest();
        request.mediatorApi = mediatorApi;
        interactor.onCreate(request);
    }

    public void setupUI(PlaceMapOnCreateViewModel viewModel) {
        //setContentView(R.layout.activity_place_map_main);
        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            //actionbar.setTitle(getString(R.string.title_place_map));
            actionbar.setTitle(viewModel.title);
        }

        // Obtain the Map Fragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*
    @Override
    protected void setupUI() {
        //setContentView(R.layout.activity_place_map_main);
        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_map));
        }

        // Obtain the Map Fragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    */

    public void setupLocationManager(PlaceMapLocManagerViewModel viewModel) {
        final GoogleMap googleMap = viewModel.googleMap;

        // Acquire a reference to the system Location Manager
        LocationManager locationManager =
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //String locationProvider = LocationManager.NETWORK_PROVIDER;
        String locationProvider = LocationManager.GPS_PROVIDER;


        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                Log.d("MAP", "location=" + location);

                /*
                //currentLocation = location;
                googleMap.clear();
                displayLocation(googleMap, location);
                displayPlaces(googleMap);
                */

                PlaceMapOnLocationRequest request =
                    new PlaceMapOnLocationRequest(PlaceMapActivity.this);
                //PlaceMapOnLocationRequest request = new PlaceMapOnLocationRequest();
                request.googleMap = googleMap;
                request.location = location;
                interactor.onLocationChanged(request);
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


        locationManager.requestLocationUpdates(
            locationProvider, 0, 0, locationListener);

    }

    @Override
    public void goToPlaceDetails(PlaceMapOnClickViewModel viewModel) {
        router.goToPlaceDetails(viewModel.placeId);
    }


//    private void setupLocationManager(final GoogleMap googleMap) {
//        // Acquire a reference to the system Location Manager
//        LocationManager locationManager =
//            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        //String locationProvider = LocationManager.NETWORK_PROVIDER;
//        String locationProvider = LocationManager.GPS_PROVIDER;
//
//
//        // Define a listener that responds to location updates
//        LocationListener locationListener = new LocationListener() {
//            public void onLocationChanged(Location location) {
//                // Called when a new location is found by the network location provider.
//                Log.d("MAP", "location=" + location);
//
//                /*
//                //currentLocation = location;
//                googleMap.clear();
//                displayLocation(googleMap, location);
//                displayPlaces(googleMap);
//                */
//
//                PlaceMapOnLocationRequest request =
//                    new PlaceMapOnLocationRequest(PlaceMapActivity.this);
//                //PlaceMapOnLocationRequest request = new PlaceMapOnLocationRequest();
//                request.googleMap = googleMap;
//                request.location = location;
//                interactor.onLocationChanged(request);
//            }
//
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            public void onProviderDisabled(String provider) {
//
//            }
//        };
//
//        // Register the listener with the Location Manager to receive location updates
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            // public void onRequestPermissionsResult(
//            //       int requestCode, String[] permissions, int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//
//
//        locationManager.requestLocationUpdates(
//            locationProvider, 0, 0, locationListener);
//
//    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        /*
        //googleMap.setOnMarkerClickListener(MainMapActivity.this);
        googleMap.setOnInfoWindowClickListener(PlaceMapActivity.this);
        displayPlaces(googleMap);

        setupLocationManager(googleMap);
        */

        PlaceMapOnReadyRequest request = new PlaceMapOnReadyRequest(PlaceMapActivity.this);
        request.googleMap = googleMap;
        interactor.onMapReady(request);
    }

    public void displayPlaces(PlaceMapOnReadyViewModel viewModel) {
        GoogleMap googleMap = viewModel.googleMap;
        List<Place> places = viewModel.places;

        // Add all markers and move the camera
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Place place : places) {

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


        if (!places.isEmpty()) {

            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen

            CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            googleMap.moveCamera(camera);
            //googleMap.animateCamera(camera);
        }
    }


    /*
    private void displayPlaces(GoogleMap googleMap) {

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


        if (!placeStore.getPlaces().isEmpty()) {

            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen

            CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            googleMap.moveCamera(camera);
            //googleMap.animateCamera(camera);
        }
    }
    */


    /*
    private void displayLocation(GoogleMap googleMap, Location location) {
        if (location == null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                return;
            }

        }

        if (location != null) {
            LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions myMarker = new MarkerOptions().position(currentLocation)
                    .title("Current Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            googleMap.addMarker(myMarker);
        }
    }
    */

    public void displayLocation(PlaceMapOnLocationViewModel viewModel) {
        GoogleMap googleMap = viewModel.googleMap;
        Location location = viewModel.location;

        if (location == null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                return;
            }

        }

        if (location != null) {
            LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions myMarker = new MarkerOptions().position(currentLocation)
                .title("Current Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            googleMap.addMarker(myMarker);
        }
    }


    /*
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

    }
    */

}
