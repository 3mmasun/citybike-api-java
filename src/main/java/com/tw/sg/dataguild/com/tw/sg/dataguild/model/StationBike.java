package com.tw.sg.dataguild.com.tw.sg.dataguild.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StationBike {
    @JsonProperty("empty_slots")
    private Integer emptySlot;
    @JsonProperty("free_bikes")
    private Integer freeBike;
    private String id;
    private float longitude;
    private float latitude;
    private String name;
    @JsonProperty("timestamp")
    private String queryTimeStamp;

    // from extra
    private String address;
    @JsonProperty("last_updated")
    private Integer lastUpdated;
    private Integer renting;
    private Integer returning;
    private String uid;

    @SuppressWarnings("unchecked")
    @JsonProperty("extra")
    private void unpackNested(Map<String, Object> extra) {
        this.address = (String) extra.get("address");
        this.lastUpdated = (Integer) extra.get("last_updated");
        this.renting = (Integer) extra.get("renting");
        this.returning = (Integer) extra.get("returning");
        this.uid = (String) extra.get("uid");
    }

    public Integer getEmptySlot() {
        return emptySlot;
    }

    public void setEmptySlot(Integer emptySlot) {
        this.emptySlot = emptySlot;
    }

    public Integer getFreeBike() {
        return freeBike;
    }

    public void setFreeBike(Integer freeBike) {
        this.freeBike = freeBike;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueryTimeStamp() {
        return queryTimeStamp;
    }

    public void setQueryTimeStamp(String queryTimeStamp) {
        this.queryTimeStamp = queryTimeStamp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getRenting() {
        return renting;
    }

    public void setRenting(Integer renting) {
        this.renting = renting;
    }

    public Integer getReturning() {
        return returning;
    }

    public void setReturning(Integer returning) {
        this.returning = returning;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

