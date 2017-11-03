package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateResponse;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceDetailInteractor implements PlaceDetailInteractorInput {

  //public static final String PARAM_PLACE_ID = "place_to_visit_id";

  private final Context managedContext;
  private PlaceStore placeStore;
  public PlaceDetailPresenterInput presenter;

  public PlaceDetailInteractor(Context managedContext) {
    this.managedContext = managedContext;
  }

  @Override
  public void onCreate(PlaceDetailOnCreateRequest request) {
    MediatorApi mediatorApi = request.mediatorApi;
    placeStore = mediatorApi.getPlaceStore();


    String placeId = request.managedIntent.getStringExtra(BaseActivity.PARAM_PLACE_ID);
    Place place = placeStore.getPlaceById(placeId);

    PlaceDetailOnCreateResponse response = new PlaceDetailOnCreateResponse();
    response.place = place;
    presenter.onCreate(response);

  }
}
