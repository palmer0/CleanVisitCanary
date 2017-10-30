package es.ulpgc.eite.master.cleanvisitcanary.scenes.intro;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;

import es.ulpgc.eite.master.cleanvisitcanary.R;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.BaseActivity;

public class IntroActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //private PlaceStore placeStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //placeStore = getManagedStore().getPlaceStore();
        setupUI();
    }


    @Override
    protected void setupUI() {
        setContentView(R.layout.activity_intro);

        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_intro));
        }

    }

}
