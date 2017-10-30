package es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts;

import android.content.Context;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListPresenterOutput {

    void setupUI(String title);
    void goToPlaceDetails(String placeId);
    Context getManagedContext();
}
