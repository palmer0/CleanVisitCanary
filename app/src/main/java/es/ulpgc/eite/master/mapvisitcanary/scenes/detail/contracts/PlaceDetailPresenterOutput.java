package es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateViewModel;

/**
 * Created by Luis on 2/11/17.
 */

public interface PlaceDetailPresenterOutput {
  //void setupUI(String title, String description, int resId);
  void setupUI(PlaceDetailOnCreateViewModel viewModel);
}
