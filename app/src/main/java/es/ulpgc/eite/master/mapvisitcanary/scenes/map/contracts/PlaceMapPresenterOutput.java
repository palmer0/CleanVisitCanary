package es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapLocManagerViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnClickViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyViewModel;

/**
 * Created by Luis on 2/11/17.
 */

public interface PlaceMapPresenterOutput {

  void setupUI(PlaceMapOnCreateViewModel viewModel);

  void displayPlaces(PlaceMapOnReadyViewModel viewModel);

  void displayLocation(PlaceMapOnLocChangedViewModel viewModel);

  void setupLocationManager(PlaceMapLocManagerViewModel viewModel);

  void onMapMarkerClicked(PlaceMapOnClickViewModel viewModel);
}
