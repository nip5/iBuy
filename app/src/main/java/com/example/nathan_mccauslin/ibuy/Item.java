package com.example.nathan_mccauslin.ibuy;

/**
 * Created by Sam on 11/7/2017.
 * Basic class for an "Item" object
 */

public class Item {
    private String item;
    private String num; /*This is not an int because setText in ItemListAdapter
    (line 49) breaks if it's an int*/
    private String category;
    private String assigned;

    public Item(String item, String num, String category, String assigned){
        this.item = item;
        this.num = num;
        this.category = category;
        this.assigned = assigned;
    }

    /*Getters and setters for everything*/
    public String getItem(){
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }
}
