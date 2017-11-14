package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nate on 11/6/2017.
 */

public class MyList extends AppCompatActivity {
    /*RESOURCE - https://www.youtube.com/watch?v=E6vE8fqQPTE */
    ArrayList<Item> myItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        onClickListenerButton();
        ListView myList = (ListView) findViewById(R.id.itemList);
        myItems = new ArrayList<>();

        /*
        *
        TESTING LIST OUT  W/O USER INPUT
        *
        */
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");
        addItem("milk", "2", "groceries", "Sam");
        addItem("bread", "2", "groceries", "Sam");

        /*
        *
        END TEST
        *
        */

        ItemListAdapter adapter = new ItemListAdapter(this, R.layout.list_layout, myItems);
        myList.setAdapter(adapter); // displaying all items from myList onto screen
    }
    public void onClickListenerButton(){
        Button addAnotherBtn = (Button) findViewById(R.id.addAnotherButton);
        addAnotherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                startActivity(new Intent(MyList.this, AddAnother.class));
            }
        });
    }
    public void addItem(String item, String num, String category, String assigned){
        Item newItem = new Item(item, num, category, assigned);
        myItems.add(newItem);
    }
    public ArrayList<Item> getList(){
        return myItems;
    }

    public void setList(ArrayList<Item> list){
        myItems = list;
    }
}
