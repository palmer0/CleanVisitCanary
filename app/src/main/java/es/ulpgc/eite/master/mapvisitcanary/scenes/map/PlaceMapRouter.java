package es.ulpgc.eite.master.mapvisitcanary.scenes.map;

/**
 * Created by imac on 30/10/17.
 */

class PlaceMapRouter {

    public PlaceMapActivity viewController;

    public void goToPlaceDetails(String placeId) {
        if(viewController != null){
            viewController.goToPlaceDetails(placeId);
        }
    }
}
