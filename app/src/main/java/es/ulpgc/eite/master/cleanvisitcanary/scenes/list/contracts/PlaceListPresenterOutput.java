package es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts;

import es.ulpgc.eite.master.cleanvisitcanary.scenes.list.models.PlaceListOnCreateViewModel;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListPresenterOutput {

    void setupUI(String title);
    //Context getManagedContext();
    void onItemListClicked(PlaceListOnCreateViewModel viewModel);
}
