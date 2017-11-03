package es.ulpgc.eite.master.mapvisitcanary.scenes.map.models;

import android.content.Context;
import android.location.Location;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Luis on 3/11/17.
 */

public class PlaceMapOnLocChangedRequest {

  public final Context managedContext;
  public GoogleMap googleMap;
  public Location location;

  public PlaceMapOnLocChangedRequest(Context context) {
    managedContext = context;
  }

}
