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
    Button saveButton;
    EditText newItemName, newAmount, newAssignee;
    ArrayList<Item> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_another);
        saveButton = (Button) findViewById(R.id.saveItem);
        newItemName = (EditText) findViewById(R.id.itemNameEdit);
        newAmount = (EditText) findViewById(R.id.itemAmount);
        newAssignee = (EditText) findViewById(R.id.assignee);
        //myList = MyList.getList();
    }

    public void onClick(View v){
        /*TO-DO:
        if "save item" is clicked, store all given info as an "Item" object
         */
        if(v==saveButton){
            addNewItem();
        }
        return;
    }
    public void addNewItem(){
        // STORE NEW INFO ABOUT ITEM
        return;
    }
    /*
    TO-DO:
    Add an array list of 5 "Item" objects of the most commonly bought items
     */
}
