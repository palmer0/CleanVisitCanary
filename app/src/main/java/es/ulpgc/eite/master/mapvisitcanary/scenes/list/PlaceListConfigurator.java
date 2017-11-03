package es.ulpgc.eite.master.mapvisitcanary.scenes.list;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListConfigurator {

    static PlaceListConfigurator instance = new PlaceListConfigurator();

    public void configure(PlaceListActivity viewController){
        //PlaceListInteractor interactor = new PlaceListInteractor(viewController);
        //PlaceListPresenter presenter = new PlaceListPresenter(viewController);
        PlaceListInteractor interactor = new PlaceListInteractor();
        PlaceListPresenter presenter = new PlaceListPresenter();
        PlaceListRouter router = new PlaceListRouter();
        viewController.interactor = interactor;
        interactor.presenter = presenter;
        presenter.viewController = viewController;
        router.viewController = viewController;
        viewController.router = router;
    }
    
}
