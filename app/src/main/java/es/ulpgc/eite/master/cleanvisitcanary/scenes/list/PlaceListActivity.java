package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;

import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.BaseActivity;
import es.ulpgc.eite.master.cleanvisitcanary.R;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListInteractorOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateRequest;


public class PlaceListActivity extends BaseActivity
        implements PlaceListInteractorOutput, PlaceListPresenterOutput {


    private PlaceListInteractor listInteractor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_place_list_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);

        listInteractor = new PlaceListInteractor(this);
        //PlaceListOnCreateRequest request = new PlaceListOnCreateRequest();
        //listInteractor = new PlaceListInteractor();
        PlaceListOnCreateRequest request = new PlaceListOnCreateRequest(this);
        request.recyclerView = recyclerView;
        listInteractor.onCreate(request);
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
    public Context getManagedContext() {
        return this;
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
    */

}
