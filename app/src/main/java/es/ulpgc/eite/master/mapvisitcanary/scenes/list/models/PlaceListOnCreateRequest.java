package es.ulpgc.eite.master.mapvisitcanary.scenes.list.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by imac on 30/10/17.
 */

public class PlaceListOnCreateRequest {

  public RecyclerView recyclerView;
  public Context managedContext;

  public PlaceListOnCreateRequest(Context context) {
    this.managedContext = context;
  }


}
