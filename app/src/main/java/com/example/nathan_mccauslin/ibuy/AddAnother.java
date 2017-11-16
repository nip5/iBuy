package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Fragment;

import java.util.ArrayList;
import java.util.Iterator;

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
    /*String[] commonItems;
    int[] commonItemsNum;*/
    /*Both allItems and allItemsNum are to create the "Commonly Added Items" list*/
    ArrayList<String> allItems = new ArrayList<>();// Keeping track of all items ever added
    ArrayList<Integer> allItemsNum = new ArrayList<>(); // The corresponding counter list
    Bundle crap = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_another);
        onClickListenerButton();
        crap = new Bundle();
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
                    // Creating the string that will appear on the list
                    newItemNameString = newItemName.getText().toString() + ",";
                    newAmountString = newAmount.getText().toString() + ",";
                    newCategoryString = newCategory.getText().toString() + ",";
                    newAssigneeString = newAssignee.getText().toString() + '\n';
                    String itemFull = newItemNameString + newAmountString+newCategoryString+newAssigneeString; //concatenating string
                    if(!items.equals("")){items += '\n';} //New line if needed
                    items += itemFull;
                    // If not already in the "all items" array, add it in and increment counter array
                    if(!checkAllItems(itemFull)){
                        allItems.add(itemFull);
                        allItemsNum.add(1);
                    }
                    // If new item has been added in the past, find it and increment the corresponding counter
                    else if(checkAllItems(itemFull)){
                        int foundIt = 0;
                        /*finding the index of an item in allItems to
                        find it's corresponding counter in allItemsNum*/
                        for(int i =0; i<allItems.size(); i++){
                            if(allItems.get(i).equals(itemFull)){
                                foundIt = i;
                            } //end if
                        }// end for
                        int newVal = allItemsNum.get(foundIt);
                        newVal++;
                        allItemsNum.set(foundIt, newVal);
                    }// end else if
                    else{
                        System.out.println("Something is wrong here");
                    }// end else
                    // Once new item is added or counter is changed, re-sort
                    bubbleSortAll(allItemsNum, allItems);
                    // recreate the "Commonly Added Items" list
                    createCommonList();
                    Intent intents = new Intent(AddAnother.this, MyList.class);
                    intents.putExtra("grocheryList", items);
                    startActivity(intents);
            }
        });
    }
    /*This is to sort out the most commonly added to the least commonly added items.
      It sorts the item's counter list from greatest to least and swaps the item string array
      with it.
    */
    void bubbleSortAll(ArrayList<Integer> intArray, ArrayList<String> strArray)
    {
        int n = intArray.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (intArray.get(j) < intArray.get(j+1))
                {
                    // Order the the "all" list's corresponding counter array to keep track of
                    // what items are more common
                    int temp = intArray.get(j);
                    intArray.set(j, intArray.get(j+1));
                    intArray.set(j+1, temp);
                    // Order the string array the same as it's counter array
                    String tempString = strArray.get(j);
                    strArray.set(j, strArray.get(j+1));
                    strArray.set(j+1, tempString);
                }
    }
    /*Takes in an item and checks the array list to see if it has been added before - this prevents
    * two entries of "eggs" for example. */
    public boolean checkAllItems(String item){
        for(int i = 0; i<allItems.size(); i++){
            if(item == allItems.get(i)){
                return true;
            }
        }
        return false;
    }

    public void createCommonList(){
        // Getting all the item fields
        TextView item1 = (TextView) findViewById(R.id.item1);
        TextView item2 = (TextView) findViewById(R.id.item2);
        TextView item3 = (TextView) findViewById(R.id.item3);
        TextView item4 = (TextView) findViewById(R.id.item4);
        TextView item5 = (TextView) findViewById(R.id.item5);

        // Setting the text fields to the first 5 items in allItems list
        item1.setText(addCommonItem(allItems, 0));
        String item = allItems.get(0).toString();
        System.out.println("Current List:"+allItems);
        if(allItems.size() >= 2){
            item2.setText(addCommonItem(allItems, 1));
        }

        //item3.setText(addCommonItem(allItems, 2));
       // item4.setText(addCommonItem(allItems, 3));
        //item5.setText(addCommonItem(allItems, 4));
    }
    /*This method makes sure that a null will not break the app*/
    public String addCommonItem(ArrayList<String> array, int index){
        if(!array.get(index).equals(null)){
            Intent intents = new Intent(this, MyList.class);
            intents.putExtra("commonItems", array.get(index));
            return array.get(index);
        }
        return "";
    }
    // For recovering info when switching between activities
    // Source - https://inthecheesefactory.com/blog/fragment-state-saving-best-practices/en
    // Cannot get this to work - app loses info from arraylists when switching to new activity
    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putStringArrayList("stringArray", allItems);
        outstate.putIntegerArrayList("numArray", allItemsNum);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        allItems = savedInstanceState.getStringArrayList("stringArray");
        allItemsNum = savedInstanceState.getIntegerArrayList("numArray");
    }

}
