package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateViewModel;


public class PlaceDetailActivity
    extends BaseActivity  implements PlaceDetailPresenterOutput {

    //public static final String PARAM_PLACE_ID = "place_to_visit_id";

    //private PlaceStore placeStore;
    public PlaceDetailInteractor interactor;
    public PlaceDetailRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MediatorApi mediatorApi = (MediatorApi) getApplication();
        //placeStore = mediatorApi.getPlaceStore();

        setContentView(R.layout.activity_place_detail);
        //setupUI();

        PlaceDetailConfigurator.instance.configure(this);

        PlaceDetailOnCreateRequest request = new PlaceDetailOnCreateRequest();
        request.mediatorApi = mediatorApi;
        request.managedIntent = getIntent();
        interactor.onCreate(request);
    }

    /*
    public void setupUI(String title, String description, int pictureResId) {


        setupToolbar(title);

        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(description);
        ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

        placePicture.setImageResource(pictureResId);
    }
    */

    public void setupUI(PlaceDetailOnCreateViewModel viewModel) {


        setupToolbar(viewModel.title);

        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(viewModel.description);
        ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

        placePicture.setImageResource(viewModel.picResId);
    }

    /*
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
    */


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
