package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Nate on 11/6/2017.
 */

public class PurchaseAnalytics extends AppCompatActivity {
    Intent intents;
    String listItems;
    TextView analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_analytics);
        Intent i = getIntent();
        listItems = i.getStringExtra("grocheryList");
        analysis = (TextView) findViewById(R.id.userAndQuantity);
        analysis.setText(listItems);
        System.out.println("listItems: " + listItems);
    }

}
