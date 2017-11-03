package es.ulpgc.eite.master.mapvisitcanary.scenes.map.models;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Luis on 2/11/17.
 */

public class PlaceMapOnReadyRequest {

  public GoogleMap googleMap;
  public Context managedContext;

  public PlaceMapOnReadyRequest(Context context) {
    managedContext = context;
  }
}
