package es.ulpgc.eite.master.cleanvisitcanary.scenes.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.cleanvisitcanary.models.Place;
import es.ulpgc.eite.master.cleanvisitcanary.R;


public class PlaceDetailActivity extends BaseActivity {

    public static final String PARAM_PLACE_ID = "place_to_visit_id";

    private PlaceStore placeStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        placeStore = getManagedStore().getPlaceStore();
        setContentView(R.layout.activity_place_detail);
        setupUI();
    }

    @Override
    protected void setupUI() {
        //setContentView(R.layout.activity_place_detail);

        String placeId = getIntent().getStringExtra(PARAM_PLACE_ID);
        Place place = placeStore.getPlaceById(placeId);

        if (place != null) {
            setupToolbar(place.title);

            TextView placeDetail = (TextView) findViewById(R.id.place_detail);
            placeDetail.setText(place.description);
            ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

            int resId = getResources().getIdentifier(place.picture, "drawable", getPackageName());
            placePicture.setImageResource(resId);
        }
    }


    private void setupToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            //actionbar.setHomeButtonEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setTitle(title);
        }
    }


}
