package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Nate on 11/6/2017.
 */

public class AddAnother extends AppCompatActivity{
    EditText newItemName, newAmount, newAssignee, newCategory;
    MyList myList;
    String newItemNameString;
    String items;
    String newAmountString;
    String newCategoryString;
    String newAssigneeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_another);
        onClickListenerButton();
        // Getting all user input fields

        newItemName = (EditText) findViewById(R.id.itemNameEdit);
        newAmount = (EditText) findViewById(R.id.itemAmount);
        newAssignee = (EditText) findViewById(R.id.assignee);
        newCategory = (EditText) findViewById(R.id.category);
        Intent i = getIntent();
        items = i.getStringExtra("grocheryList");
        System.out.println("items: " + items);

        if(items == null){
            items = "";
        }
        // Getting list from the MyList class and setting it to "newList" so we can add
        // more items to the list
        myList = new MyList();
    }

    public void onClickListenerButton(){
        Button saveButton = (Button) findViewById(R.id.saveItem);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    newItemNameString = newItemName.getText().toString() + ",";
                    newAmountString = newAmount.getText().toString() + ",";
                    newCategoryString = newCategory.getText().toString() + ",";
                    newAssigneeString = newAssignee.getText().toString() + '\n';
                    String itemFull = newItemNameString + newAmountString+newCategoryString+newAssigneeString;
                    if(!items.equals("")){items += '\n';}
                    items += itemFull;
                    //System.out.println("items: " + items);
                    Intent intents = new Intent(AddAnother.this, MyList.class);
                    intents.putExtra("grocheryList", items);
                    startActivity(intents);
            }
        });
    }
    /*
    TO-DO:
    Add an array list of 5 "Item" objects of the most commonly bought items
     */
}
