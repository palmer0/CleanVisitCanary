package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts.PlaceMapPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyResponse;
import es.ulpgc.eite.master.mapvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceMapInteractor implements PlaceMapInteractorInput {

  public PlaceMapPresenterInput presenter;
  private PlaceStore placeStore;


  @Override
  public void onCreate(final PlaceMapOnCreateRequest request) {
    final Context context = request.managedContext;

    PlaceStoreWorker storeWorker = new PlaceStoreWorker();
    storeWorker.loadStore(context, new PlaceStoreWorker.PlaceStoreLoaderHandler() {

      @Override
      public void onPlaceStoreLoaded(PlaceStore placeStore) {
        setPlaceStore(placeStore);

        PlaceMapOnCreateResponse response = new PlaceMapOnCreateResponse();
        response.title = context.getString(R.string.title_place_map);
        presenter.onCreate(response);
      }
    });

  }

  @Override
  public void onMapReady(PlaceMapOnReadyRequest request) {

    PlaceMapOnReadyResponse response = new PlaceMapOnReadyResponse();
    response.googleMap = request.googleMap;
    response.managedContext = request.managedContext;
    response.places = placeStore.getPlaces();
    presenter.onMapReady(response);
  }

  @Override
  public void onLocationChanged(PlaceMapOnLocChangedRequest request) {
    PlaceMapOnLocChangedResponse response = new PlaceMapOnLocChangedResponse();
    response.googleMap = request.googleMap;
    response.places = placeStore.getPlaces();
    response.location = request.location;
    presenter.onLocationChanged(response);
  }


  private void setPlaceStore(PlaceStore placeStore) {
    this.placeStore = placeStore;
  }

}
