package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

/**
 * Created by imac on 30/10/17.
 */

class PlaceMapRouter {

  public PlaceMapActivity viewController;

  public void onMapMarkerClicked(String placeId) {
    if (viewController != null) {
      viewController.goToPlaceDetails(placeId);
    }
  }


  public void onNavigationMapSelected() {
    if (viewController != null) {
      viewController.goToPlaceMap();
    }
  }

  public void onNavigationListSelected() {
    if (viewController != null) {
      viewController.goToPlaceList();
    }
  }

}
