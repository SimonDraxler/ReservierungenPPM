package com.ttssoftware.android.reservierung;

/**
 * Created by Simon on 27.01.2016.
 */
public class Reservierung {

    public String sport, zeit;
    public int court;

    public Reservierung(String sport, String zeit, int court) {
        this.sport = sport;
        this.zeit = zeit;
        this.court = court;
    }

    public String getZeit() {
        return zeit;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getCourt() {
        return court;
    }

    public void setCourt(int court) {
        this.court = court;
    }
}
