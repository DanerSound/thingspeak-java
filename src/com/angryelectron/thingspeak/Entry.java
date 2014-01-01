package com.angryelectron.thingspeak;

import java.util.Date;
import java.util.HashMap;

/**
 * Channel entry.  Contains a single dataset which is used to update channels
 * and is returned by feeds.  
 */
public class Entry {
    
    /**
     * The names of these private members must match the JSON fields in a
     * channel's feed. If they don't, GSON might not be able to deserialize the
     * JSON feed into Entry objects. Note that 'longitude' and 'latitude' are
     * returned by feeds, but 'lat' and 'long' are used when updating.
     */
    private Date created_at;
    private Integer entry_id;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private Double latitude;
    private Double longitude;
    private Double elevation;
    private String status;
    private String twitter;
    private String tweet;
    
    private final HashMap<String, Object> updateMap = new HashMap<>();

    /**
     * Get a map of all fields in a format compatible with the API's update
     * parameters.
     * @return Field map.
     */
    protected HashMap<String, Object> getUpdateMap() {        
        return updateMap;
    }
            
    /**
     * Get data for field.
     * @param field 1-8
     * @return Field data - cast to appropriate type.
     */
    public Object getField(Integer field) {
        switch(field) {
            case 1:
                return field1;
            case 2:
                return field2;
            case 3:
                return field3;
            case 4:
                return field4;
            case 5:
                return field5;
            case 6:
                return field6;
            case 7:
                return field7;
            case 8:
                return field8;                
        }
        throw new IllegalArgumentException("Invalid field.");
    }

    /**
     * Set the value for a field.
     * @param field 1-8.
     * @param value Value for field.  Type depends on channel config.
     */
    public void setField(Integer field, String value) {
        switch(field) {
            case 1:
                field1 = value;
                updateMap.put("field1", value);
                return;
            case 2:
                field2 = value;
                updateMap.put("field2", value);
                return;
            case 3:
                field3 = value;
                updateMap.put("field3", value);
                return;
            case 4:
                field4 = value;
                updateMap.put("field4", value);
                return;
            case 5:
                field5 = value;
                updateMap.put("field5", value);
                return;
            case 6:
                field6 = value;
                updateMap.put("field6", value);
                return;
            case 7:
                field7 = value;
                updateMap.put("field7", value);
                return;
            case 8:
                field8 = value;
                updateMap.put("field8", value);
                return;
        }
        throw new IllegalArgumentException("Invalid field.");
    }
    
    /**
     * Get latitude.
     * @return Latitude, in decimal degrees.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Set latitude.     
     * @param latitude Latitude, in decimal degrees.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
        updateMap.put("lat", latitude);
    }

    /**
     * Get longitude.
     * @return Longitude, in decimal degrees.
     */
    public Double getLongitude() {        
        return longitude;
    }

    /**
     * Set longitude.
     * @param longitude Longitude, in decimal degrees. 
     */
    public void setLong(Double longitude) {
        this.longitude = longitude;
        updateMap.put("long", longitude);
    }

    /**
     * Get elevation.
     * @return Elevation, in meters.
     */
    public Double getElevation() {
        return elevation;
    }

    /**
     * Set elevation.
     * @param elevation Elevation, in meters. 
     */
    public void setElevation(Double elevation) {
        this.elevation = elevation;
        updateMap.put("elevation", elevation);
    }

    /**
     * Get status.
     * @return Status string.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set status.
     * @param status Status string. 
     */
    public void setStatus(String status) {
        this.status = status;
        updateMap.put("status", status);
    }

    /**
     * Get Twitter username.  If set, a tweet will be posted to the user's 
     * twitter feed for each channel update.
     * @return Twitter username.
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * Set Twitter username.  If set, a tweet will be posted to the user's
     * twitter feed for each channel update.
     * @param twitter Twitter username.
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
        updateMap.put("twitter", twitter);
    }

    /**
     * Get Twitter message.  This message will be posted to the user's twitter 
     * feed for each channel update.
     * @return 
     */
    public String getTweet() {
        return tweet;
    }

    /**
     * Set Twitter message.  This message will be posted to the user's twitter
     * feed for each channel update.
     * @param tweet Twitter message.
     */
    public void setTweet(String tweet) {
        this.tweet = tweet;
        updateMap.put("tweet", tweet);
    }

    /**
     * Get date on which this channel entry was created.  Use the offset setting
     * in FeedParameters to adjust to local timezones.
     * @return Date.
     */
    public Date getCreated() {        
        return created_at;
    }

    /**
     * Get the ID of this entry.
     * @return Entry ID.
     */
    public Integer getEntryId() {
        return entry_id;
    }                  
}
