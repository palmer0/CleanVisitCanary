package es.ulpgc.eite.master.mapvisitcanary.scenes.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.master.mapvisitcanary.R;
import es.ulpgc.eite.master.mapvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts.PlaceDetailPresenterOutput;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateViewModel;


public class PlaceDetailActivity
    extends BaseActivity implements PlaceDetailPresenterOutput {


  public PlaceDetailInteractor interactor;
  public PlaceDetailRouter router;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_detail);

    PlaceDetailConfigurator.instance.configure(this);

    PlaceDetailOnCreateRequest request = new PlaceDetailOnCreateRequest(this);
    request.managedIntent = getIntent();
    interactor.onCreate(request);
  }


  public void setupUI(PlaceDetailOnCreateViewModel viewModel) {
    setupToolbar(viewModel.title);

    TextView placeDetails = (TextView) findViewById(R.id.place_detail);
    placeDetails.setText(viewModel.description);
    ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

    placePicture.setImageResource(viewModel.picResId);
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

  @Override
  protected void onNavigationItemSelected(int itemId) {

  }

}
