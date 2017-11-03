package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapLocManagerViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyViewModel;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceMapPresenter implements PlaceMapPresenterInput {

  public PlaceMapPresenterOutput viewController;

  /*
  public PlaceMapPresenter(PlaceMapActivity viewController) {

  }
  */

  @Override
  public void onCreate(PlaceMapOnCreateResponse response) {
    //viewController.setupUI(response.title);
    PlaceMapOnCreateViewModel viewModel = new PlaceMapOnCreateViewModel();
    viewModel.title = response.title;
    viewController.setupUI(viewModel);

  }

  @Override
  public void onMapReady(PlaceMapOnReadyResponse response) {
    GoogleMap googleMap = response.googleMap;

    googleMap.setOnMarkerClickListener(response.markerClickListener);
    googleMap.setOnInfoWindowClickListener(response.infoWindowClickListener);

    //displayPlaces(googleMap);
    displayPlaces(response.googleMap, response.places);
    //setupLocationManager(response.managedContext, googleMap);

    //displayPlaces(response.googleMap, response.managedContext, response.places);
    //viewController.displayPlaces(response.googleMap, response.places);

    /*
    PlaceMapOnReadyViewModel viewModel = new PlaceMapOnReadyViewModel();
    viewModel.googleMap = response.googleMap;
    viewModel.places = response.places;
    viewController.displayPlaces(viewModel);
    */

    PlaceMapLocManagerViewModel viewModel = new PlaceMapLocManagerViewModel();
    viewModel.googleMap = response.googleMap;
    viewController.setupLocationManager(viewModel);
  }

  @Override
  public void onLocationChanged(PlaceMapOnLocationResponse response) {
    GoogleMap googleMap = response.googleMap;

    googleMap.clear();
    //displayLocation(googleMap, location);
    //displayPlaces(response.googleMap, response.managedContext, response.places);
    displayPlaces(response.googleMap, response.places);

    PlaceMapOnLocationViewModel viewModel = new PlaceMapOnLocationViewModel();
    viewModel.googleMap = response.googleMap;
    viewModel.location = response.location;
    viewController.displayLocation(viewModel);
  }

  private void displayPlaces(GoogleMap googleMap, List<Place> places) {
    PlaceMapOnReadyViewModel viewModel = new PlaceMapOnReadyViewModel();
    viewModel.googleMap = googleMap;
    viewModel.places = places;
    viewController.displayPlaces(viewModel);
  }


  /*
  private void displayPlaces(GoogleMap googleMap, Context context, List<Place> places) {

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
      int width = context.getResources().getDisplayMetrics().widthPixels;
      int height = context.getResources().getDisplayMetrics().heightPixels;
      int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen

      CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
      googleMap.moveCamera(camera);
      //googleMap.animateCamera(camera);
    }
  }
  */

  /*
  private void setupLocationManager(Context context, final GoogleMap googleMap) {

    // Acquire a reference to the system Location Manager
    LocationManager locationManager =
        (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

    //String locationProvider = LocationManager.NETWORK_PROVIDER;
    String locationProvider = LocationManager.GPS_PROVIDER;


    // Define a listener that responds to location updates
    LocationListener locationListener = new LocationListener() {
      public void onLocationChanged(Location location) {
        // Called when a new location is found by the network location provider.
        Log.d("MAP", "location=" + location);

        googleMap.clear();
        //displayLocation(googleMap, location);
        //displayPlaces(googleMap);
        displayPlaces(googleMap, response.places);

        PlaceMapOnLocationViewModel viewModel = new PlaceMapOnLocationViewModel();
        viewModel.googleMap = googleMap;
        viewModel.location = location;
        viewController.displayLocation(viewModel);
      }

      public void onStatusChanged(String provider, int status, Bundle extras) {

      }

      public void onProviderEnabled(String provider) {

      }

      public void onProviderDisabled(String provider) {

      }
    };

    // Register the listener with the Location Manager to receive location updates
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
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
  */

}
