package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;


import android.content.Context;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.MediatorApi;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateResponse;
import es.ulpgc.eite.master.cleanvisitcanary.workers.PlaceStoreWorker;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListInteractor implements PlaceListInteractorInput {


    private final Context managedContext;
    public PlaceListPresenterInput presenter;
    //private PlaceListInteractorOutput viewController;
    //private PlaceStore placeStore;

    public PlaceListInteractor(Context managedContext) {
        this.managedContext = managedContext;
    }

    /*
    public PlaceListInteractor(PlaceListInteractorOutput viewController) {
        this.viewController = viewController;
    }
    */


    @Override
    public void onCreate(final PlaceListOnCreateRequest request) {
        //final Context managedContext = viewController.getManagedContext();
        //final Context managedContext = request.managedContext;
        final MediatorApi mediatorApi = request.mediatorApi;

        PlaceStoreWorker storeWorker = new PlaceStoreWorker();
        storeWorker.loadStore(managedContext, new PlaceStoreWorker.PlaceStoreLoaderHandler() {

            @Override
            public void onPlaceStoreLoaded(PlaceStore placeStore) {
                //setPlaceStore(placeStore);
                mediatorApi.setPlaceStore(placeStore);

                //presenter = new PlaceListPresenter(request.viewController);
                //PlaceListOnCreateResponse response = new PlaceListOnCreateResponse();
                PlaceListOnCreateResponse response = new PlaceListOnCreateResponse(managedContext);
                response.recyclerView = request.recyclerView;
                response.placeStore = placeStore;
                presenter.onCreate(response);
            }
        });

    }

    /*
    private void setPlaceStore(PlaceStore placeStore) {
        this.placeStore = placeStore;
    }
    */

}
