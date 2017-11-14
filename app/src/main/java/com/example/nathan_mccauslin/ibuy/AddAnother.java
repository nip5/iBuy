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
    ArrayList<Item> newList;

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
        // Getting list from the MyList class and setting it to "newList" so we can add
        // more items to the list
        myList = new MyList();
        newList = new ArrayList<Item>();
        newList = myList.getList();
    }

    public void onClickListenerButton(){
        Button saveButton = (Button) findViewById(R.id.saveItem);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addNewItem();
                    //System.out.println("Save item clicked");
                    startActivity(new Intent(AddAnother.this, MyList.class));
            }
        });
    }

    public void addNewItem(){
        String newItemNameString = newItemName.getText().toString();
        String newAmountString = newAmount.getText().toString();
        String newCategoryString = newCategory.getText().toString();
        String newAssigneeString = newAssignee.getText().toString();
        myList.addItem(newItemNameString, newAmountString, newCategoryString, newAssigneeString);
        return;
    }
    /*
    TO-DO:
    Add an array list of 5 "Item" objects of the most commonly bought items
     */
}
