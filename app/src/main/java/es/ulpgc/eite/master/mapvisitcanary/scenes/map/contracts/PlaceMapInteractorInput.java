package es.ulpgc.eite.master.mapvisitcanary.scenes.map.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnCreateRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnLocChangedRequest;
import es.ulpgc.eite.master.mapvisitcanary.scenes.map.models.PlaceMapOnReadyRequest;

/**
 * Created by Luis on 2/11/17.
 */

public interface PlaceMapInteractorInput {

  void onCreate(PlaceMapOnCreateRequest request);

  void onMapReady(PlaceMapOnReadyRequest request);

  void onLocationChanged(PlaceMapOnLocChangedRequest request);
}
