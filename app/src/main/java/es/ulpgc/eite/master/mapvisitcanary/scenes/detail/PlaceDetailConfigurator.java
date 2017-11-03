package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;


/**
 * Created by imac on 30/10/17.
 */

public class PlaceDetailConfigurator {

    static PlaceDetailConfigurator instance = new PlaceDetailConfigurator();

    public void configure(PlaceDetailActivity viewController){
        PlaceDetailInteractor interactor = new PlaceDetailInteractor(viewController);
        PlaceDetailPresenter presenter = new PlaceDetailPresenter(viewController);
        PlaceDetailRouter router = new PlaceDetailRouter();
        viewController.interactor = interactor;
        interactor.presenter = presenter;
        presenter.viewController = viewController;
        router.viewController = viewController;
        viewController.router = router;
    }
    
}
