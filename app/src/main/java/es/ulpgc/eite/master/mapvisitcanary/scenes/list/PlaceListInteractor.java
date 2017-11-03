package es.ulpgc.eite.master.mapvisitcanary.scenes.list;


import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts.PlaceListInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts.PlaceListPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListInteractor implements PlaceListInteractorInput {


    public PlaceListPresenterInput presenter;


    @Override
    public void onCreate(final PlaceListOnCreateRequest request) {
        final Context context = request.managedContext;

        PlaceStoreWorker storeWorker = new PlaceStoreWorker();
        storeWorker.loadStore(context, new PlaceStoreWorker.PlaceStoreLoaderHandler() {

            @Override
            public void onPlaceStoreLoaded(PlaceStore placeStore) {

                PlaceListOnCreateResponse response = new PlaceListOnCreateResponse(context);
                response.recyclerView = request.recyclerView;
                response.places = placeStore.getPlaces();
                presenter.onCreate(response);
            }
        });

    }

}
