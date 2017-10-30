package es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models;

import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterOutput;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListOnCreateRequest {

    public final PlaceListPresenterOutput viewController;
    public RecyclerView recyclerView;

    public PlaceListOnCreateRequest(PlaceListPresenterOutput viewController) {
        this.viewController = viewController;
    }

}
