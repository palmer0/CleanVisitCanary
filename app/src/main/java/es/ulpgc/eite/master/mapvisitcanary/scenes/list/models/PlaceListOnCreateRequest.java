package es.ulpgc.eite.master.mapvisitcanary.scenes.list.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListOnCreateRequest {

    //public final PlaceListPresenterOutput viewController;
    public RecyclerView recyclerView;
    public Context managedContext;
    public MediatorApi mediatorApi;

    public PlaceListOnCreateRequest(Context context) {
        this.managedContext = context;
    }

    /*
    public PlaceListOnCreateRequest(PlaceListPresenterOutput viewController) {
        this.viewController = viewController;
    }
    */

}
