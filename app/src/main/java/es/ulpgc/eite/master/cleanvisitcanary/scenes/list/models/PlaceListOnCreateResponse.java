package es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListOnCreateResponse {

    public RecyclerView recyclerView;
    public PlaceStore placeStore;
    public Context managedContext;

    public PlaceListOnCreateResponse(Context managedContext) {
        this.managedContext = managedContext;
    }
}
