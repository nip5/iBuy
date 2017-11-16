package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Nate on 11/6/2017.
 */

public class MyList extends AppCompatActivity {
    /*RESOURCE - https://www.youtube.com/watch?v=E6vE8fqQPTE */
    ArrayList<String> myItems;
    TextView listItem;
    String listItems;
    String menuString;
    Intent intent;
    Intent menu;
    Intent addAnother;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        listItem  = (TextView) findViewById(R.id.itemList);
        onClickListenerButton();
        Intent i = getIntent();
        menu = new Intent(this, HomeActivity.class);
        listItems = i.getStringExtra("grocheryList");
        menuString = i.getStringExtra("grocheryList");
        menu.putExtra("grocheryList", listItems);
        if(listItems == null){
            listItems = "";
        }
        addAnother = new Intent(this, AddAnother.class);
        intent = new Intent(this, MyList.class);
        intent.putExtra("grocheryList", listItems);
        addAnother.putExtra("grocheryList", listItems);
        listItems = modString(listItems);
        System.out.println("listItems: " + listItems);
        listItem.setText(listItems);
    }
    public void onClickListenerButton(){
        final Button addAnotherBtn = (Button) findViewById(R.id.addAnotherButton);
        Button menuBtn = (Button) findViewById(R.id.backMenuButton);
        Button resetBtn = (Button) findViewById(R.id.deleteListButton);
        addAnotherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                startActivity(addAnother);

            }
        });
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                startActivity(menu);

            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                listItems = "";
                Intent intent = new Intent(MyList.this, MyList.class);
                intent.putExtra("grocheryList", listItems);
                startActivity(intent);
                //startActivity(new Intent(HomeActivity.this, MyList.class));
            }
        });
    }
    public String modString(String itemAmtCatAssign){
        itemAmtCatAssign = itemAmtCatAssign.replaceAll(",", "               ") + '\n';
        return itemAmtCatAssign;
    }
    public ArrayList<String> getList(){
        return myItems;
    }

    public void setList(ArrayList<String> list){
        myItems = list;
    }
}
