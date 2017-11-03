package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.contracts.IntroPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.intro.models.IntroOnCreateViewModel;

public class IntroActivity extends BaseActivity
    implements IntroPresenterOutput, NavigationView.OnNavigationItemSelectedListener {


  public IntroInteractorInput interactor;
  public IntroRouter router;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    IntroConfigurator.instance.configure(this);

    IntroOnCreateRequest request = new IntroOnCreateRequest(this);
    interactor.onCreate(request);
  }


  @Override
  public void setupUI(IntroOnCreateViewModel viewModel) {
    super.setupUI();

    ActionBar actionbar = getSupportActionBar();
    if (actionbar != null) {
      actionbar.setTitle(viewModel.title);
    }

  }

  @Override
  protected void onNavigationItemSelected(int itemId) {

    if (itemId == R.id.nav_map) {
      // Handle the map action
      router.onNavigationMapSelected();

    } else if (itemId == R.id.nav_list) {
      // Handle the list action
      router.onNavigationListSelected();

    }
  }
}
