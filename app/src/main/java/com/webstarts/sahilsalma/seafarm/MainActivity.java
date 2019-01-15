package com.webstarts.sahilsalma.seafarm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText startDate;
    private EditText endDate;
    private EditText startTime;
    private EditText duration;
    private EditText minQty;
    private EditText startingBid;
    private EditText fishType;
    private EditText tQty;
    private EditText a_miniQty;
    private EditText a_bidPrice;
    private Button login;
    private Button placeAuction;
    private Button bid;
    private TextView register;
    private TextView a_fishName;
    private TextView a_sellerName;
    private TextView a_rating;
    private ImageButton fishImg;
    private Auction auction1;
    private Auction auction2;
    private ImageView a_fishV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        home();
    }
    private void initialize(){
        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.Login);
        register = findViewById(R.id.register);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        startTime = findViewById(R.id.startTime);
        duration = findViewById(R.id.duration);
        minQty = findViewById(R.id.minQty);
        startingBid = findViewById(R.id.startingBid);
        fishType   = findViewById(R.id.fishType);
        tQty = findViewById(R.id.quantity);
        placeAuction = findViewById(R.id.placeAuction);
        fishImg = findViewById(R.id.fishImg);
        bid = findViewById(R.id.bid);
        a_miniQty = findViewById(R.id.Miniqty);
        a_bidPrice = findViewById(R.id.MiniBid);
        a_fishName = findViewById(R.id.fishName);
        a_sellerName = findViewById(R.id.SellerInfo);
        a_rating = findViewById(R.id.rating);
        a_fishV = findViewById(R.id.fishV);
    }
    private void home(){
        final AlertDialog.Builder nA = new AlertDialog.Builder(this);
        nA.setCancelable(false);
        nA.setTitle("Sorry");
        nA.setMessage("Functionality unavailable at this time");
        nA.setPositiveButton("OK",null);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals("xyz")){
                    if (username.getText().toString().equals("seller")){
                        setContentView(R.layout.seller);
                        startSell();
                    }
                    else if (username.getText().toString().equals("buyer")){
                        setContentView(R.layout.view);
                        startBuy();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nA.show();
            }
        });
    }
    private void startSell(){
        if(placeAuction != null) {
            placeAuction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seller();
                }
            });
        }
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
                home();
            }
        });

    }
    private void startBuy(){
        if (bid != null) {
            bid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyer();
                }
            });
        }
        findViewById(R.id.a_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
                home();
            }
        });
    }
    private void seller(){
        final String fishName = fishType.getText().toString();
        final String sDate = startDate.getText().toString();
        final String eDate = endDate.getText().toString();
        final String sTime = startTime.getText().toString();
        final String sellerName = username.getText().toString();
        final String dur = duration.getText().toString();
        final int mQty = Integer.parseInt(minQty.getText().toString());
        final Double sBid = Double.parseDouble(startingBid.getText().toString());
        final int totalQty = Integer.parseInt(tQty.getText().toString());
        final Toast created = new Toast(this);
        created.setText("Auction created");
        created.setDuration(Toast.LENGTH_SHORT);
        auction1 = new Auction(fishName,totalQty,sBid,
                mQty,sDate,eDate,sTime,dur,sellerName,5);
        created.show();
        auction();



    }

    private void buyer(){
        final Double bidP = Double.parseDouble(a_bidPrice.getText().toString());
        final int qty = Integer.parseInt(a_miniQty.getText().toString());
        auction1.addOffer(new Offer(qty,bidP,auction1));

    }

    private void auction(){
        String fishName = fishType.getText().toString();
        String sDate = startDate.getText().toString();
        String eDate = endDate.getText().toString();
        String sTime = startTime.getText().toString();
        String sellerName = username.getText().toString();
        String dur = duration.getText().toString();
        int mQty = Integer.parseInt(minQty.getText().toString());
        Double sBid = Double.parseDouble(startingBid.getText().toString());
        int totalQty = Integer.parseInt(tQty.getText().toString());
        int rate = auction1.getrating();

        a_fishName.setText(fishName);
        a_sellerName.setText("Seller: "+sellerName);
        a_rating.setText("rating: "+String.valueOf(rate)+"/5");
        a_miniQty.setText(String.valueOf(mQty)+" lb");
        a_bidPrice.setText("$"+String.valueOf(sBid)+"/lb");
        //a_fishV.setImageResource(fishImg.getI)
    }

}

