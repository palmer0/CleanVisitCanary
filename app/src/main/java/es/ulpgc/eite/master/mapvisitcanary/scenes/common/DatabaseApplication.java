package es.ulpgc.eite.master.mapvisitcanary.scenes.common;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by imac on 29/10/17.
 */

public class DatabaseApplication extends Application { //implements MediatorApi {


    //private PlaceStore placeStore;

    @Override
    public void onCreate() {
        super.onCreate();

        setupDatabase();
    }


    private void setupDatabase() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("visitcanary.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    /*
    @Override
    public void setPlaceStore(PlaceStore placeStore) {
        this.placeStore = placeStore;

    }

    @Override
    public PlaceStore getPlaceStore() {
        return placeStore;
    }
    */
}
