package es.ulpgc.eite.master.mapvisitcanary.scenes.list;

/**
 * Created by imac on 30/10/17.
 */

class PlaceListRouter {

  public PlaceListActivity viewController;

  public void onItemListClicked(String placeId) {
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

  public void onNavigationIntroSelected() {
    if (viewController != null) {
      viewController.goToIntro();
    }
  }

}
