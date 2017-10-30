package es.ulpgc.eite.master.cleanvisitcanary.scenes.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import es.ulpgc.eite.master.cleanvisitcanary.R;
import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.detail.PlaceDetailActivity;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.intro.IntroActivity;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.PlaceListActivity;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.map.PlaceMapActivity;

/**
 * Created by Luis on 23/10/17.
 */

public class BaseActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  protected PlaceStore placeStore;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //placeStore = new PlaceStore(this);
    //setupUI();
  }


  protected void setupUI(){

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }




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

  public void goToPlaceDetails(String placeId ) {
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