package es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnClickViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateViewModel;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListPresenterOutput {

  void setupUI(PlaceListOnCreateViewModel title);

  void onItemListClicked(PlaceListOnClickViewModel viewModel);
}
