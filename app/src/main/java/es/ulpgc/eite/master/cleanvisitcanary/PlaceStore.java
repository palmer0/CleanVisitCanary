package es.ulpgc.eite.master.cleanvisitcanary;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;


public class PlaceStore {

    private final Context managedContext;
    private Realm realmDatabase;
    //private List<Place> places = new ArrayList();
    private RealmResults<Place> places;

    public PlaceStore(Context managedContext){
        this.managedContext = managedContext;
        realmDatabase = Realm.getDefaultInstance();
        fillPlaceStoreFromDatabase();
    }

    /*
    public PlaceStore(List<String> titles, List<String> descs, List<String> pics, List<String> locs) {
        for (int position = 0; position < titles.size(); position++) {

            final String id = String.valueOf(position);
            final String title = titles.get(position);
            final String detail = descs.get(position);
            final String picture = pics.get(position);
            final String location = locs.get(position);

            addPlace(createPlace(position, title, detail, picture, location));

        }
    }
    */

    private void fillPlaceStoreFromDatabase(){
        places = realmDatabase.where(Place.class).findAll();
        //places = places.sort("title");
        places = places.sort(Place.KEY_TITLE);

        if(places.isEmpty()){
            fillPlaceStoreFromAssets();
        }
    }


    private JSONArray loadJSONFromAssets(String filename) {
        try {

            InputStream is = managedContext.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            JSONArray array = new JSONArray(json);
            return array;

        } catch (Exception ex) {

        }

        //return new JSONArray();
        return null;
    }



    private void fillPlaceStoreFromAssets(){

        List<String> titles = new ArrayList();
        List<String> descriptions = new ArrayList();
        List<String> pictures = new ArrayList();
        List<String> locations = new ArrayList();

        JSONArray array = loadJSONFromAssets("places.json");
        for(int index=0; index < array.length(); index++){
            try {

                JSONObject obj = array.getJSONObject(index);
                String title = obj.getString(Place.KEY_TITLE);
                String description = obj.getString(Place.KEY_DESC);
                String picture = obj.getString(Place.KEY_PIC);
                String location = obj.getString(Place.KEY_LOC);

                locations.add(location);
                titles.add(title);
                pictures.add(picture);
                descriptions.add(description);

            } catch (JSONException e) {

            }
        }

        fillPlaceStoreFromAssets(titles, descriptions, pictures, locations);

        //Log.d("JSONArray", placeStore.toJSONArray().toString());
    }

    private void fillPlaceStoreFromAssets(
            List<String> titles, List<String> descs, List<String> pics, List<String> locs) {

        for (int position = 0; position < titles.size(); position++) {

            final String id = String.valueOf(position);
            final String title = titles.get(position);
            final String detail = descs.get(position);
            final String picture = pics.get(position);
            final String location = locs.get(position);

            realmDatabase = Realm.getDefaultInstance();
            realmDatabase.beginTransaction();
            createPlace(id, title, detail, picture, location);
            realmDatabase.commitTransaction();

        }
    }



    public JSONArray toJSONArray () {
        JSONArray array = new JSONArray();
        for(Place place: places) {
            JSONObject obj = place.toJSONObject();
            Log.d("JSONObject", obj.toString());
            array.put(obj);
            //array.put(place.toJSONObject());
        }

        return array;
    }

    /*
    private void addPlace(Place place) {
        places.add(place);
    }
    */

    /*
    private Place createPlace(int position, String title, String desc, String pic, String loc ) {
        return new Place(String.valueOf(position), title, desc, pic, loc);

    }
    */

    private void createPlace(String id, String title, String desc, String pic, String loc ) {
        Place place = realmDatabase.createObject(Place.class, id);
        place.setTitle(title);
        place.setDescription(desc);
        place.setLocation(loc);
        place.setPicture(pic);

        Log.d("RealmObject", place.toString());

    }


    public List<Place> getPlaces(){
        return places;
    }

    public Place getPlaceByPosition(int position) {
        return places.get(position);
    }

    public Place getPlaceById(String id) {
        Integer position = Integer.valueOf(id);
        return getPlaceByPosition(position);
    }

    /*
    public class Place {

        public static final String KEY_TITLE = "title";
        public static final String KEY_DESC = "description";
        public static final String KEY_PIC= "picture";
        public static final String KEY_LOC= "location";

        public final String id;
        public final String title;
        public final String description;
        public final String picture;
        public final String location;


        public Place(String id, String title, String description, String picture, String location) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.picture = picture;
            this.location = location;
        }


        public JSONObject toJSONObject () {

            JSONObject obj = new JSONObject() ;

            try {

                obj.put(KEY_TITLE, title);
                obj.put(KEY_DESC, description);
                obj.put(KEY_PIC, picture);
                obj.put(KEY_LOC, location);

            } catch (JSONException e) {

            }

            return obj;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    */

}
