package es.ulpgc.eite.master.cleanvisitcanary.scenes.intro;

import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;

import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.cleanvisitcanary.R;

public class IntroActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener {


  @Override
  protected void setupUI() {
    setContentView(R.layout.activity_intro);

    super.setupUI();

    ActionBar actionbar = getSupportActionBar();
    if (actionbar != null) {
      actionbar.setTitle(getString(R.string.title_place_list));
    }

  }

}
