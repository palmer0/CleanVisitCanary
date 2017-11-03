package es.ulpgc.eite.master.mapvisitcanary.scenes.list.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.list.models.PlaceListOnNavigationRequest;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListInteractorInput {

  void onCreate(PlaceListOnCreateRequest request);

}
