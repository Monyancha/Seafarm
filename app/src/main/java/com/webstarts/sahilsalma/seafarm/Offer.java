package com.webstarts.sahilsalma.seafarm;

public class Offer {
    private int mquantity;
    private double mbid;
    private Auction mauctionName;

    public Offer(int quantity, double bid, Auction auctionName) {
        this.mquantity = quantity;
        this.mbid = bid;
        this.mauctionName = auctionName;
    }

    public int getquantity() {
        return mquantity;
    }

    public double getbid() {
        return mbid;
    }

    public Auction getauctionName() {
        return mauctionName;
    }
}
