package es.ulpgc.eite.master.cleanvisitcanary;

import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;

public class IntroActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  /*
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setupUI();
  }
  */

  @Override
  protected void setupUI() {
    setContentView(R.layout.activity_intro);

    super.setupUI();

    ActionBar actionbar = getSupportActionBar();
    if (actionbar != null) {
      actionbar.setTitle(getString(R.string.title_place_list));
    }

  }

  /*
  private void setupUI(){
    setContentView(R.layout.activity_intro);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.intro_menu, menu);
    return true;
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  */

  /*
  private void goToPlaceMap( ) {
    Intent intent = new Intent(MainActivity.this, PlaceMapActivity.class);
    startActivity(intent);
    finish();
  }

  private void goToPlaceList( ) {
    Intent intent = new Intent(MainActivity.this, PlaceListActivity.class);
    startActivity(intent);

    finish();
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
      goToPlaceList();



    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
  */

}
