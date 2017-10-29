package es.ulpgc.eite.master.cleanvisitcanary;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by imac on 29/10/17.
 */

public class Place extends RealmObject {

    public static final String KEY_TITLE = "title";
    public static final String KEY_DESC = "description";
    public static final String KEY_PIC= "picture";
    public static final String KEY_LOC= "location";

    @Required
    @PrimaryKey
    public String id;
    @Required
    public String title;
    @Required
    public String description;
    @Required
    public String picture;
    @Required
    public String location;

    public Place() {

    }

    public Place(String id, String title, String description, String picture, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.location = location;
    }



    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setLocation(String location) {
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
