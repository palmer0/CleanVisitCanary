package es.ulpgc.eite.master.mapvisitcanary.scenes.list.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListOnCreateResponse {

    public RecyclerView recyclerView;
    //public PlaceStore placeStore;
    public Context managedContext;
    public List<Place> places;

    public PlaceListOnCreateResponse(Context context) {
        this.managedContext = context;
    }
}
