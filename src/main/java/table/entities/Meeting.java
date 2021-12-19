package table.entities;

import java.sql.Timestamp;

public class Meeting {
    private int mid;
    private String location;
    private int teamCap;
    private Timestamp time;

    public Meeting(int mid, String location, int teamCap, Timestamp time) {
        this.mid = mid;
        this.location = location;
        this.teamCap = teamCap;
        this.time = time;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTeamCap() {
        return teamCap;
    }

    public void setTeamCap(int teamCap) {
        this.teamCap = teamCap;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
