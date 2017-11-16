package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    String listItems;
    Intent analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onClickListenerButton();
        Intent i = getIntent();
        listItems = i.getStringExtra("grocheryList");
        analysis = new Intent(this, PurchaseAnalytics.class);
        analysis.putExtra("grocheryList", listItems);
        System.out.println("listItems in main: " + listItems);
    }
    public void onClickListenerButton(){
        Button myListBtn = (Button) findViewById(R.id.myListButton);
        Button purchaseAnalyticsBtn = (Button) findViewById(R.id.purchaseAnalyticsButton);
        myListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                startActivity(new Intent(HomeActivity.this, MyList.class));
            }
        });
        purchaseAnalyticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                startActivity(analysis);
            }
        });
    }

}
