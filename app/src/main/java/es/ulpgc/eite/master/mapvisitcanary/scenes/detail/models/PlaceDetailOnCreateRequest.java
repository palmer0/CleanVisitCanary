package es.ulpgc.eite.master.mapvisitcanary.scenes.detail.models;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Luis on 2/11/17.
 */

public class PlaceDetailOnCreateRequest {

  public Intent managedIntent;
  public Context managedContext;

  public PlaceDetailOnCreateRequest(Context context) {
    managedContext = context;
  }
}
