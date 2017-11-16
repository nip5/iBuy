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
    TextView analysis1;
    TextView analysis2;
    String[] users = new String[2];//users,everything else
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_analytics);
        Intent i = getIntent();
        //listItems = i.getStringExtra("grocheryList");
        listItems = ("Lemons,5,Food,Sam\nWood,32,Utility,Nate\nMilk,2,Food,Nate");//testing
        users = listItems.split("\n");
        int countSam = 0;
        int countNate = 0;
        for(int j = 0; j < users.length;j++) {
            System.out.println("users: " + users[j]);
            if(users[j].contains("Nate")){
                countNate++;
            }
            if(users[j].contains("Sam")){
                countSam++;
            }
        }
        analysis1 = (TextView) findViewById(R.id.userAndQuantity1);
        analysis1.setText("Sam: " + countSam);
        analysis2 = (TextView) findViewById(R.id.userAndQuantity2);
        analysis2.setText("Nate: " + countNate);
        System.out.println("listItems: " + listItems);
    }

}
