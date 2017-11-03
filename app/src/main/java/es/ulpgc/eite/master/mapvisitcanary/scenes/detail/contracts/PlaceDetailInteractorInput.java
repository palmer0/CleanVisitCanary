package es.ulpgc.eite.master.mapvisitcanary.scenes.detail.contracts;

import es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models.PlaceDetailOnCreateRequest;

/**
 * Created by Luis on 2/11/17.
 */

public interface PlaceDetailInteractorInput {
  void onCreate(PlaceDetailOnCreateRequest request);
}
