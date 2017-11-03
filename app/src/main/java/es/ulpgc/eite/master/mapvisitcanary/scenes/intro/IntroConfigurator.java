package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;



/**
 * Created by imac on 30/10/17.
 */

public class IntroConfigurator {

    static IntroConfigurator instance = new IntroConfigurator();

    public void configure(IntroActivity viewController){
        IntroInteractor interactor = new IntroInteractor();
        IntroPresenter presenter = new IntroPresenter();
        IntroRouter router = new IntroRouter();
        viewController.interactor = interactor;
        interactor.presenter = presenter;
        presenter.viewController = viewController;
        router.viewController = viewController;
        viewController.router = router;
    }
    
}
