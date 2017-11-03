package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapLocManagerViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnClickViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyViewModel;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceMapPresenter implements PlaceMapPresenterInput,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

  public PlaceMapPresenterOutput viewController;


  @Override
  public void onCreate(PlaceMapOnCreateResponse response) {
    PlaceMapOnCreateViewModel viewModel = new PlaceMapOnCreateViewModel();
    viewModel.title = response.title;
    viewController.setupUI(viewModel);

  }

  @Override
  public void onMapReady(PlaceMapOnReadyResponse response) {
    GoogleMap googleMap = response.googleMap;

    googleMap.setOnInfoWindowClickListener(this);
    //googleMap.setOnMarkerClickListener(this);
    displayPlaces(response.googleMap, response.places);


    PlaceMapLocManagerViewModel viewModel = new PlaceMapLocManagerViewModel();
    viewModel.googleMap = response.googleMap;
    viewController.setupLocationManager(viewModel);
  }

  private void displayPlaces(GoogleMap googleMap, List<Place> places) {
    PlaceMapOnReadyViewModel viewModel = new PlaceMapOnReadyViewModel();
    viewModel.googleMap = googleMap;
    viewModel.places = places;
    viewController.displayPlaces(viewModel);
  }

  @Override
  public void onLocationChanged(PlaceMapOnLocChangedResponse response) {
    GoogleMap googleMap = response.googleMap;

    //googleMap.clear();
    //displayPlaces(response.googleMap, response.places);

    PlaceMapOnLocChangedViewModel viewModel = new PlaceMapOnLocChangedViewModel();
    viewModel.googleMap = googleMap;
    viewModel.location = response.location;
    viewController.displayLocation(viewModel);
  }


  @Override
  public boolean onMarkerClick(Marker marker) {
    String placeId = marker.getSnippet();
    onMapMarkerClicked(placeId);

    return true;
  }

  @Override
  public void onInfoWindowClick(Marker marker) {
    String placeId = marker.getSnippet();
    onMapMarkerClicked(placeId);
  }

  private void onMapMarkerClicked(String placeId) {
    PlaceMapOnClickViewModel viewModel = new PlaceMapOnClickViewModel();
    viewModel.placeId = placeId;
    viewController.onMapMarkerClicked(viewModel);
  }


}
