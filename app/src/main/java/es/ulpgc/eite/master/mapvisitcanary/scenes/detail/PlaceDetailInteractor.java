package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceDetailInteractor implements PlaceDetailInteractorInput {


  public PlaceDetailPresenterInput presenter;


  @Override
  public void onCreate(final PlaceDetailOnCreateRequest request) {
    final Context context = request.managedContext;

    PlaceStoreWorker storeWorker = new PlaceStoreWorker();
    storeWorker.loadStore(context, new PlaceStoreWorker.PlaceStoreLoaderHandler() {

      @Override
      public void onPlaceStoreLoaded(PlaceStore placeStore) {

        Intent intent = request.managedIntent;
        String placeId = intent.getStringExtra(BaseActivity.PARAM_PLACE_ID);
        Place place = placeStore.getPlaceById(placeId);

        PlaceDetailOnCreateResponse response = new PlaceDetailOnCreateResponse();
        response.place = place;
        response.managedContext = context;
        presenter.onCreate(response);
      }
    });

  }


}
