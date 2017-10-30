package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;

/**
 * Created by imac on 30/10/17.
 */

class PlaceListRouter {

    public PlaceListActivity viewController;

    public void goToPlaceDetails(String placeId) {
        if(viewController != null){
            viewController.goToPlaceDetails(placeId);
        }
    }
}
