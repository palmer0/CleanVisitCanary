package es.ulpgc.eite.master.mapvisitcanary.scenes.intro;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;

public class IntroActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
        setupUI();
    }


    @Override
    protected void setupUI() {
        //setContentView(R.layout.activity_intro);
        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_intro));
        }

    }

}
