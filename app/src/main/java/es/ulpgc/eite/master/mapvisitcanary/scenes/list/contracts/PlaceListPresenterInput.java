package es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnNavigationResponse;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListPresenterInput {

  void onCreate(PlaceListOnCreateResponse response);

}
