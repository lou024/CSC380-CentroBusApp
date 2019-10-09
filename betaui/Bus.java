package com.example.betaui;

public class Bus {
    public int busID;
    public String onRoute;
    public int index;
    public int ETA;


    public void makeBus(int busID, String onRoute, int index, int ETA){
        this.index = index;
        this.onRoute = onRoute;
        this.busID = busID;
        this.ETA = ETA;
    }
}
