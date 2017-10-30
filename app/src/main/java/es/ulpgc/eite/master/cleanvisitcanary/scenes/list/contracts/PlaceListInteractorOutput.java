package es.ulpgc.eite.master.cleanvisitcanary.scenes.list.contracts;

import android.content.Context;

import es.ulpgc.eite.master.cleanvisitcanary.scenes.common.ManagedStore;

/**
 * Created by imac on 30/10/17.
 */

public interface PlaceListInteractorOutput {

    Context getManagedContext();
    ManagedStore getManagedStore();
}
