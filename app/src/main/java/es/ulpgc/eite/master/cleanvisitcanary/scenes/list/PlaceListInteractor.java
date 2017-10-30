package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;


import android.content.Context;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateResponse;
import es.ulpgc.eite.master.cleanvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListInteractor implements PlaceListInteractorInput {


    private PlaceStore placeStore;
    private PlaceListPresenterInput listPresenter;
    //private PlaceListPresenterOutput listView;
    private PlaceListInteractorOutput listView;

    public PlaceListInteractor(PlaceListInteractorOutput listView) {
        this.listView = listView;
    }

    /*
    public PlaceListInteractor(PlaceListPresenterOutput listView) {
        this.listView = listView;
        listPresenter = new PlaceListPresenter(listView);
    }
    */

    /*
    public PlaceListInteractor() {
        listView = null;
    }
    */

    @Override
    public void onCreate(final PlaceListOnCreateRequest request) {
        //listView = request.listView;

        Context managedContext = listView.getManagedContext();
        PlaceStoreWorker storeWorker = new PlaceStoreWorker();
        storeWorker.loadStore(managedContext, new PlaceStoreWorker.OnPlaceStoreLoaderHandler() {

            @Override
            public void onPlaceStoreLoaded(PlaceStore placeStore) {
                setupPlaceStore(placeStore);

                listPresenter = new PlaceListPresenter(request.listView);
                PlaceListOnCreateResponse response = new PlaceListOnCreateResponse();
                response.recyclerView = request.recyclerView;
                response.placeStore = placeStore;
                listPresenter.onCreate(response);
            }
        });

    }

    private void setupPlaceStore(PlaceStore placeStore){
        this.placeStore = placeStore;
    }
}
