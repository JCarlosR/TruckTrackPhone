package com.programacionymas.trucktrackphone.model;

/*
{
"id":26,"
route_id":9,
"departure_date":"2017-08-11","departure_time":"20:00:00",
"user_id":8,"started_at":null,
"route_name":"El Porvenir - UNT","driver_name":"Julio"
}
*/

public class Travel {

    private int id;
    private int route_id;
    private String departure_date;
    private String departure_time;
    private int user_id;
    private String started_at;
    private String route_name;
    private String driver_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getDepartureDate() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDepartureTime() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getRouteName() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public String getDriverName() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
}
