package es.ulpgc.eite.master.cleanvisitcanary.scenes.common;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;

/**
 * Created by imac on 30/10/17.
 */

public interface MediatorApi {

    void setPlaceStore(PlaceStore placeStore);
    PlaceStore getPlaceStore();
}
