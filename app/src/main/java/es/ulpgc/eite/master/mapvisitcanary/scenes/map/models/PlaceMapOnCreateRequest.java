package es.ulpgc.eite.master.mapvisitcanary.scenes.map.models;

import android.content.Context;

import es.ulpgc.eite.master.mapvisitcanary.scenes.common.MediatorApi;

/**
 * Created by Luis on 2/11/17.
 */

public class PlaceMapOnCreateRequest {

  public final Context managedContext;
  public MediatorApi mediatorApi;

  public PlaceMapOnCreateRequest(Context context) {
    managedContext = context;
  }


  /*
  public PlaceMapOnCreateRequest(Context managedContext) {

  }
  */
}
