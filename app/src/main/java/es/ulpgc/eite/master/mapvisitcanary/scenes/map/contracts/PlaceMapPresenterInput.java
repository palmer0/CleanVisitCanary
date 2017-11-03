package es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateResponse;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocationResponse;

/**
 * Created by Luis on 2/11/17.
 */

public interface PlaceMapPresenterInput {

  void onCreate(PlaceMapOnCreateResponse response);
  void onMapReady(PlaceMapOnReadyResponse response);
  void onLocationChanged(PlaceMapOnLocationResponse response);
}
