package es.ulpgc.eite.master.cleanvisitcanary;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class PlaceListActivity extends BaseActivity {

    //private PlaceStore placeStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fillPlaceStoreFromResources();
        setupUI();

    }


    /*

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    */

    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            // Handle the map action
            goToPlaceMap();

        } else if (id == R.id.nav_list) {
            // Handle the list action
            //goToPlaceList();

        } else if (id == R.id.nav_intro) {
            goToMain();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    */

    @Override
    protected void setupUI() {
        setContentView(R.layout.activity_place_list_main);

        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_list));
        }

        setupRecyclerView();
    }

    /*
    private void setupUI(){
        setContentView(R.layout.activity_place_list_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_list));
        }

        setupRecyclerView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    */

    /*
    private void setupUI(){
        setContentView(R.layout.activity_place_list);

        setupToolbar();
        setupRecyclerView();
    }


    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle(getTitle());

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_list));
        }

    }
    */

    private void setupRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
        recyclerView.setAdapter(new PlaceRecyclerViewAdapter(placeStore.getPlaces()));
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

    class PlaceRecyclerViewAdapter
            extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.PlaceViewHolder> {

        private List<Place> places;

        public PlaceRecyclerViewAdapter(List<Place> places) {
            this.places = places;
        }

        @Override
        public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.place_list_content, parent, false);
            return new PlaceViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final PlaceViewHolder holder, int position) {
            holder.placeItem = places.get(position);
            holder.placeTitleView.setText(places.get(position).title);

            holder.placeView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    goToPlaceDetails(holder.placeItem.id);

                    /*
                    Context context = view.getContext();
                    Intent intent = new Intent(context, PlaceDetailActivity.class);
                    intent.putExtra(PlaceDetailActivity.PARAM_PLACE_ID, holder.placeItem.id);
                    context.startActivity(intent);
                    */
                }
            });
        }

        @Override
        public int getItemCount() {
            return places.size();
        }

        class PlaceViewHolder extends RecyclerView.ViewHolder {
            public final View placeView;
            public final TextView placeTitleView;
            public Place placeItem;

            public PlaceViewHolder(View view) {
                super(view);
                placeView = view;
                placeTitleView = view.findViewById(R.id.place_title);
            }

            @Override
            public String toString() {
                return placeTitleView.getText().toString();
            }
        }
    }

    /*

    private void goToPlaceDetails(String placeId ) {
        Intent intent = new Intent(PlaceListActivity.this, PlaceDetailActivity.class);
        intent.putExtra(PlaceDetailActivity.PARAM_PLACE_ID, placeId);
        startActivity(intent);
    }

    private void goToPlaceMap( ) {
        Intent intent = new Intent(PlaceListActivity.this, PlaceMapActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToPlaceList( ) {
        Intent intent = new Intent(PlaceListActivity.this, PlaceListActivity.class);
        startActivity(intent);
        finish();
    }


    private void goToMain( ) {
        Intent intent = new Intent(PlaceListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    */

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_map_button) {
            goToPlaceMap();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
