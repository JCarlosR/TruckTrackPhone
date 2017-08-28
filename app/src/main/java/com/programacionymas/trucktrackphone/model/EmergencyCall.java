package com.programacionymas.trucktrackphone.model;

/*
{
"id":1,
"user_id":6,"travel_id":2,
"lat":"123","lng":"456",
"route_name":"Lima - Trujillo",
"user":{"name":"Javier Sanchez","id":6}
}*/
public class EmergencyCall {

    private int id;
    private String lat;
    private String lng;
    private String route_name;
    private User user;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getRouteName() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
