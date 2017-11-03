package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroPresenterInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateViewModel;

/**
 * Created by imac on 3/11/17.
 */

class IntroPresenter implements IntroPresenterInput {

  public IntroPresenterOutput viewController;

  @Override
  public void onCreate(IntroOnCreateResponse response) {
    Context context = response.managedContext;

    IntroOnCreateViewModel viewModel = new IntroOnCreateViewModel();
    viewModel.title = context.getString(R.string.title_intro);
    viewController.setupUI(viewModel);
  }
}
