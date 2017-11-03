package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateViewModel;

/**
 * Created by Luis on 2/11/17.
 */

class PlaceDetailPresenter implements PlaceDetailPresenterInput{

  public PlaceDetailPresenterOutput viewController;

  @Override
  public void onCreate(PlaceDetailOnCreateResponse response) {
    Context context = response.managedContext;
    Place place = response.place;

    int picResId = context.getResources().getIdentifier(
        place.picture, "drawable", context.getPackageName());

    PlaceDetailOnCreateViewModel viewModel = new PlaceDetailOnCreateViewModel();
    viewModel.description = place.description;
    viewModel.title = place.title;
    viewModel.picResId = picResId;
    viewController.setupUI(viewModel);
  }
}
