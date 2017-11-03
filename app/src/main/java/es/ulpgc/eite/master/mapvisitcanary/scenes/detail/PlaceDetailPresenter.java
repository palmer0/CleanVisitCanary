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

  private final Context managedContext;
  public PlaceDetailPresenterOutput viewController;

  public PlaceDetailPresenter(PlaceDetailActivity viewController) {
    this.viewController = viewController;
    managedContext = viewController;
  }

  @Override
  public void onCreate(PlaceDetailOnCreateResponse response) {
    PlaceDetailOnCreateViewModel viewModel = new PlaceDetailOnCreateViewModel();

    Place place = response.place;
    int resId = managedContext.getResources().getIdentifier(
        place.picture, "drawable", managedContext.getPackageName());

    //viewController.setupUI(place.title, place.description, resId);
    viewModel.description = place.description;
    viewModel.title = place.title;
    viewModel.picResId = resId;
    viewController.setupUI(viewModel);
  }
}
