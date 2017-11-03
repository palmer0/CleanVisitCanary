package es.ulpgc.eite.master.mapvisitcanary.scenes.common;

import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;

/**
 * Created by imac on 30/10/17.
 */

public interface MediatorApi {

    void setPlaceStore(PlaceStore placeStore);
    PlaceStore getPlaceStore();
}
