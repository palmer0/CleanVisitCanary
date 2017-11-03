package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationResponse;
import es.ulpgc.eite.master.mapvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceMapInteractor implements PlaceMapInteractorInput,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

  //private final Context managedContext;
  public PlaceMapPresenterInput presenter;
  private PlaceStore placeStore;

  /*
  public PlaceMapInteractor(Context managedContext) {
    this.managedContext = managedContext;
  }
  */


  @Override
  public void onCreate(final PlaceMapOnCreateRequest request) {
    final Context context = request.managedContext;
    final MediatorApi mediatorApi = request.mediatorApi;

    PlaceStoreWorker storeWorker = new PlaceStoreWorker();
    storeWorker.loadStore(context, new PlaceStoreWorker.PlaceStoreLoaderHandler() {

      @Override
      public void onPlaceStoreLoaded(PlaceStore placeStore) {
        setPlaceStore(placeStore);
        mediatorApi.setPlaceStore(placeStore);

        PlaceMapOnCreateResponse response = new PlaceMapOnCreateResponse();
        response.title = context.getString(R.string.title_place_map);
        presenter.onCreate(response);
      }
    });

  }

  @Override
  public void onMapReady(PlaceMapOnReadyRequest request) {

    PlaceMapOnReadyResponse response = new PlaceMapOnReadyResponse();
    response.markerClickListener = this;
    response.infoWindowClickListener = this;
    response.googleMap = request.googleMap;
    response.managedContext = request.managedContext;
    response.places = placeStore.getPlaces();
    presenter.onMapReady(response);
  }

  @Override
  public void onLocationChanged(PlaceMapOnLocationRequest request) {
    PlaceMapOnLocationResponse response = new PlaceMapOnLocationResponse();
    response.googleMap = request.googleMap;
    //response.managedContext = request.managedContext;
    response.places = placeStore.getPlaces();
    response.location = request.location;
    presenter.onLocationChanged(response);
  }


  /*
  @Override
  public void onCreate(PlaceMapOnCreateRequest request) {
    PlaceMapOnCreateResponse response = new PlaceMapOnCreateResponse();
    response.title = managedContext.getString(R.string.title_place_map);
    presenter.onCreate(response);

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

  }

  private void goToPlaceDetails(String placeId){

  }

  private void setPlaceStore(PlaceStore placeStore) {
    this.placeStore = placeStore;
  }

}
