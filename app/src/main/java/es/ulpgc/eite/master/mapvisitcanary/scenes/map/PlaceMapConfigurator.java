package es.ulpgc.eite.master.mapvisitcanary.scenes.map;


/**
 * Created by imac on 30/10/17.
 */

public class PlaceMapConfigurator {

    static PlaceMapConfigurator instance = new PlaceMapConfigurator();

    public void configure(PlaceMapActivity viewController){
        PlaceMapInteractor interactor = new PlaceMapInteractor();
        PlaceMapPresenter presenter = new PlaceMapPresenter();
        PlaceMapRouter router = new PlaceMapRouter();
        viewController.interactor = interactor;
        interactor.presenter = presenter;
        presenter.viewController = viewController;
        router.viewController = viewController;
        viewController.router = router;
    }
    
}
