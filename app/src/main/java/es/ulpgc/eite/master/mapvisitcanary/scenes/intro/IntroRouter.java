package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;

/**
 * Created by imac on 30/10/17.
 */

class IntroRouter {

  public IntroActivity viewController;

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
