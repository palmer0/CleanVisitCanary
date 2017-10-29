package es.ulpgc.eite.master.cleanvisitcanary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Luis on 23/10/17.
 */

public class BaseActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  protected PlaceStore placeStore;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //fillPlaceStoreFromResources();
    //fillPlaceStoreFromAssets();
    placeStore = new PlaceStore(this);
    setupUI();
  }


  protected void setupUI(){

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    /*
    ActionBar actionbar = getSupportActionBar();
    if (actionbar != null) {
      actionbar.setTitle(getString(R.string.title_place_list));
    }
    */


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  /*
  private JSONArray loadJSONFromAssets(String filename) {
    try {

      InputStream is = getAssets().open(filename);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();

      String json = new String(buffer, "UTF-8");
      JSONArray array = new JSONArray(json);
      return array;

    } catch (Exception ex) {

    }

    //return new JSONArray();
    return null;
  }



  private void fillPlaceStoreFromAssets(){
    
    List<String> titles = new ArrayList();
    List<String> descriptions = new ArrayList();
    List<String> pictures = new ArrayList();
    List<String> locations = new ArrayList();

    JSONArray array = loadJSONFromAssets("places.json");
    for(int index=0; index < array.length(); index++){
      try {

        JSONObject obj = array.getJSONObject(index);
        String title = obj.getString(Place.KEY_TITLE);
        String description = obj.getString(Place.KEY_DESC);
        String picture = obj.getString(Place.KEY_PIC);
        String location = obj.getString(Place.KEY_LOC);

        locations.add(location);
        titles.add(title);
        pictures.add(picture);
        descriptions.add(description);

      } catch (JSONException e) {

      }
    }

    placeStore = new PlaceStore(titles, descriptions, pictures, locations);

    //Log.d("JSONArray", placeStore.toJSONArray().toString());
  }
  */

  /*
  protected void fillPlaceStoreFromResources(){
    Resources res = getResources();
    List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
    List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
    List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));
    List<String> locations = Arrays.asList(res.getStringArray(R.array.places_locations));

    placeStore = new PlaceStore(titles, details, pictures, locations);
  }
  */


  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }


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
      goToPlaceList();

    } else if (id == R.id.nav_intro) {
      goToMain();

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  protected void goToPlaceDetails(String placeId ) {
    Intent intent = new Intent(BaseActivity.this, PlaceDetailActivity.class);
    intent.putExtra(PlaceDetailActivity.PARAM_PLACE_ID, placeId);
    startActivity(intent);
  }


  protected void goToPlaceMap( ) {
    Intent intent = new Intent(BaseActivity.this, PlaceMapActivity.class);
    startActivity(intent);
    finish();
  }

  protected void goToPlaceList( ) {
    Intent intent = new Intent(BaseActivity.this, PlaceListActivity.class);
    startActivity(intent);
    finish();
  }


  protected void goToMain( ) {
    Intent intent = new Intent(BaseActivity.this, IntroActivity.class);
    startActivity(intent);
    finish();
  }
}
