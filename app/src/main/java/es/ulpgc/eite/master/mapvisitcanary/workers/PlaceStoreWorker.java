package es.ulpgc.eite.master.mapvisitcanary.workers;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceStoreWorker {

  public interface PlaceStoreLoaderHandler {
    void onPlaceStoreLoaded(PlaceStore placeStore);
  }

  public void loadStore(Context managedContext, PlaceStoreLoaderHandler completionHandler) {
    PlaceStore placeStore = new PlaceStore(managedContext);
    if (completionHandler != null) {
      completionHandler.onPlaceStoreLoaded(placeStore);
    }
  }
}
