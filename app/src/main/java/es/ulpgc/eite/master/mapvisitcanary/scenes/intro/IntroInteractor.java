package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;

import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateResponse;

/**
 * Created by imac on 3/11/17.
 */

class IntroInteractor implements IntroInteractorInput {

  public IntroPresenterInput presenter;

  @Override
  public void onCreate(IntroOnCreateRequest request) {

    IntroOnCreateResponse response = new IntroOnCreateResponse();
    response.managedContext = request.managedContext;
    presenter.onCreate(response);

  }
}
