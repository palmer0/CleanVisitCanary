package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.cleanvisitcanary.R;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateViewModel;


public class PlaceListActivity extends BaseActivity
        implements PlaceListInteractorOutput, PlaceListPresenterOutput {


    public PlaceListInteractorInput interactor;
    public PlaceListRouter router;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_place_list_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);

        PlaceListConfigurator.instance.configure(this);
        //interactor = new PlaceListInteractor(this);
        PlaceListOnCreateRequest request = new PlaceListOnCreateRequest(this);
        request.recyclerView = recyclerView;
        interactor.onCreate(request);
    }


    @Override
    public void setupUI(String title) {
        //setContentView(R.layout.activity_place_list_main);
        super.setupUI();

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            //actionbar.setTitle(getString(R.string.title_place_list));
            actionbar.setTitle(title);
        }

        //setupRecyclerView();
    }

    @Override
    public void goToPlaceDetails(PlaceListOnCreateViewModel viewModel) {
        //goToPlaceDetails(viewModel.placeId);
        router.goToPlaceDetails(viewModel.placeId);
    }


    /*
    private void setupRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
        recyclerView.setAdapter(new PlaceRecyclerViewAdapter(placeStore.getPlaces()));
    }
    */


    /*
    private class PlaceRecyclerViewAdapter
            extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.PlaceViewHolder> {

        private List<Place> places;

        public PlaceRecyclerViewAdapter(List<Place> places) {
            this.places = places;
        }

        @Override
        public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewController = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.place_list_content, parent, false);
            return new PlaceViewHolder(viewController);
        }

        @Override
        public void onBindViewHolder(final PlaceViewHolder holder, int position) {
            holder.placeItem = places.get(position);
            holder.placeTitleView.setText(places.get(position).title);

            holder.placeView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View viewController) {
                    goToPlaceDetails(holder.placeItem.id);

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

            public PlaceViewHolder(View viewController) {
                super(viewController);
                placeView = viewController;
                placeTitleView = viewController.findViewById(R.id.place_title);
            }

            @Override
            public String toString() {
                return placeTitleView.getText().toString();
            }
        }
    }
    */

}
