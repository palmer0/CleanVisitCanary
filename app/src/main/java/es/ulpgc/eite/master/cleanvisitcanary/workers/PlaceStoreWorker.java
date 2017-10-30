package es.ulpgc.eite.master.cleanvisitcanary.workers;

import android.content.Context;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceStoreWorker {

    public interface PlaceStoreLoaderHandler {
        void onPlaceStoreLoaded(PlaceStore placeStore);
    }

    public void loadStore(Context managedContext, PlaceStoreLoaderHandler handler) {
        PlaceStore placeStore = new PlaceStore(managedContext);
        if (handler != null) {
            handler.onPlaceStoreLoaded(placeStore);
        }
    }
}
