package es.ulpgc.eite.master.cleanvisitcanary.scenes.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.master.cleanvisitcanary.R;
import es.ulpgc.eite.master.cleanvisitcanary.models.Place;
import es.ulpgc.eite.master.cleanvisitcanary.models.PlaceStore;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterInput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts.PlaceListPresenterOutput;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateResponse;
import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateViewModel;

/**
 * Created by imac on 30/10/17.
 */

class PlaceListPresenter implements PlaceListPresenterInput {

    public PlaceListPresenterOutput viewController;

    public PlaceListPresenter(PlaceListPresenterOutput viewController) {
        this.viewController = viewController;
    }

    @Override
    public void onCreate(PlaceListOnCreateResponse response) {
        if (viewController != null) {
            Context managedContext = viewController.getManagedContext();
            String title = managedContext.getString(R.string.title_place_list);
            viewController.setupUI(title);
            setupRecyclerView(response.recyclerView, response.placeStore);
        }
    }

    private void setupRecyclerView(RecyclerView recyclerView, PlaceStore placeStore) {
        if (recyclerView != null) {
            recyclerView.setAdapter(new PlaceRecyclerViewAdapter(placeStore.getPlaces()));
        }
    }


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
                    onItemListClicked(holder.placeItem.id);

                    /*
                    if (viewController != null) {
                        viewController.goToPlaceDetails(holder.placeItem.id);
                    }
                    */
                }
            });
        }

        private void onItemListClicked(String placeId){
            if (viewController != null) {
                PlaceListOnCreateViewModel viewModel = new PlaceListOnCreateViewModel(placeId);
                viewController.goToPlaceDetails(viewModel);
            }
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



}
