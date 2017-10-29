package es.ulpgc.eite.master.cleanvisitcanary;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class PlaceDetailActivity extends BaseActivity {

    public static final String PARAM_PLACE_ID = "place_to_visit_id";

    //private PlaceStore placeStore;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fillPlaceStoreFromResources();
        setupUI();

    }
    */

    @Override
    protected void setupUI(){
        setContentView(R.layout.activity_place_detail);

        String placeId = getIntent().getStringExtra(PARAM_PLACE_ID);
        Place place = placeStore.getPlaceById(placeId);

        if (place != null) {
            setupToolbar(place.title);

            TextView placeDetail = (TextView) findViewById(R.id.place_detail);
            placeDetail.setText(place.description);
            ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

            int resId= getResources().getIdentifier(place.picture, "drawable", getPackageName());
            placePicture.setImageResource(resId);
        }
    }

    /*
    private void fillPlaceStoreFromResources(){
        Resources res = getResources();
        List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
        List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
        List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));
        List<String> locations = Arrays.asList(res.getStringArray(R.array.places_locations));

        placeStore = new PlaceStore(titles, details, pictures, locations);
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



    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //navigateUpTo(new Intent(this, PlaceListActivity.class));
            //return true;
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    */


}
