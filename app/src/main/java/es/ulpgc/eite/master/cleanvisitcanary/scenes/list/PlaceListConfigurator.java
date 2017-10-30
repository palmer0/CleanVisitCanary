package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListConfigurator {

    static PlaceListConfigurator instance = new PlaceListConfigurator();

    public void configure(PlaceListActivity viewController){
        PlaceListInteractor interactor = new PlaceListInteractor(viewController);
        PlaceListPresenter presenter = new PlaceListPresenter(viewController);
        PlaceListRouter router = new PlaceListRouter();
        viewController.interactor = interactor;
        interactor.presenter = presenter;
        presenter.viewController = viewController;
        router.viewController = viewController;
        viewController.router = router;
    }
    
}
