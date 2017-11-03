package es.ulpgc.eite.master.mapvisitcanary.scenes.list;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts.PlaceListInteractorInput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts.PlaceListPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnClickViewModel;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateViewModel;


public class PlaceListActivity extends BaseActivity implements PlaceListPresenterOutput {


  public PlaceListInteractorInput interactor;
  public PlaceListRouter router;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_list_main);

    PlaceListConfigurator.instance.configure(this);

    PlaceListOnCreateRequest request = new PlaceListOnCreateRequest(this);
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
    request.recyclerView = recyclerView;
    interactor.onCreate(request);
  }


  @Override
  public void setupUI(PlaceListOnCreateViewModel viewModel) {
    super.setupUI();

    ActionBar actionbar = getSupportActionBar();
    if (actionbar != null) {
      actionbar.setTitle(viewModel.title);
    }

  }

  @Override
  public void onItemListClicked(PlaceListOnClickViewModel viewModel) {
    router.onItemListClicked(viewModel.placeId);
  }


  @Override
  protected void onNavigationItemSelected(int itemId) {

    if (itemId == R.id.nav_map) {
      // Handle the map action
      router.onNavigationMapSelected();

    } else if (itemId == R.id.nav_list) {
      // Handle the list action
      router.onNavigationListSelected();

    } else if (itemId == R.id.nav_intro) {
      router.onNavigationIntroSelected();

    }

  }

}
