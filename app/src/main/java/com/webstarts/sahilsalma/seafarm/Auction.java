package com.webstarts.sahilsalma.seafarm;

import java.util.ArrayList;

public class Auction {
    private String mfishName;
    private int mQuantity;
    private double mstartingBid;
    private int mminQty;
    private String mstartDate;
    private String mendDate;
    private String mstartTime;
    private String mendTime;
    private ArrayList<Offer> mOffers = new ArrayList<Offer>();
    private String msellerName;
    private int mrating;

    public Auction(String fishName, int Quantity, double startingBid,
                   int minQty, String startDate, String endDate,
                   String startTime, String endTime, String sellerName, int rating) {
        this.mfishName = fishName;
        this.mQuantity = Quantity;
        this.mstartingBid = startingBid;
        this.mminQty = minQty;
        this.mstartDate = startDate;
        this.mendDate = endDate;
        this.mstartTime = startTime;
        this.mendTime = endTime;
        this.msellerName = sellerName;
        this.mrating = rating;
    }

    public String getfishName() {
        return mfishName;
    }

    public void setfishName(String fishName) {
        this.mfishName = fishName;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int Quantity) {
        this.mQuantity = Quantity;
    }

    public double getstartingBid() {
        return mstartingBid;
    }

    public void setstartingBid(double startingBid) {
        this.mstartingBid = startingBid;
    }

    public int getminQty() {
        return mminQty;
    }

    public void setminQty(int minQty) {
        this.mminQty = minQty;
    }

    public String getStartDate() {
        return mstartDate;
    }

    public void setStartDate(String startDate) {
        this.mstartDate = startDate;
    }

    public String getEndDate() {
        return mendDate;
    }

    public void setEndDate(String endDate) {
        this.mendDate = endDate;
    }

    public String getStartTime() {
        return mstartTime;
    }

    public void setStartTime(String startTime) {
        this.mstartTime = startTime;
    }

    public String getEndTime() {
        return mendTime;
    }

    public void setEndTime(String endTime) {
        this.mendTime = endTime;
    }

    public ArrayList<Offer> getOffers() {
        return mOffers;
    }

    public String getsellername(){
        return  msellerName;
    }

    public int getrating(){
        return  mrating;
    }
    public void addOffer(Offer x){
        mOffers.add(x);
    }
}

