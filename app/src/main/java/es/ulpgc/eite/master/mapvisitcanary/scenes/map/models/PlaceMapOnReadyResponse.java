package es.ulpgc.eite.master.mapvisitcanary.scenes.map.models;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;

/**
 * Created by Luis on 2/11/17.
 */

public class PlaceMapOnReadyResponse {

  public GoogleMap googleMap;
  public List<Place> places;
  public Context managedContext;
  //public GoogleMap.OnMarkerClickListener markerClickListener;
  //public GoogleMap.OnInfoWindowClickListener infoWindowClickListener;

}
