package es.ulpgc.eite.master.mapvisitcanary.scenes.map.models;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import es.ulpgc.eite.master.mapvisitcanary.models.Place;

/**
 * Created by Luis on 3/11/17.
 */

public class PlaceMapOnLocationResponse {

  //public Context managedContext;
  public GoogleMap googleMap;
  public Location location;
  public List<Place> places;
}
