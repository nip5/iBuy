package com.example.nathan_mccauslin.ibuy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kagom on 11/7/2017.
 * This class displays all info from one Item onto the screen
 */

public class ItemListAdapter extends ArrayAdapter<Item> {
    private static final String TAG = "ItemListAdapter";
    private Context myContext;
    private int myResource;

    public ItemListAdapter(Context context, int resource, ArrayList<Item> items) {
        super(context, resource, items);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Need to get item, num, category, and assignee
        String item = getItem(position).getItem();
        String num = getItem(position).getNum();
        String category = getItem(position).getCategory();
        String assignee = getItem(position).getAssigned();

        // Create a new item with all the necessary info included
        Item itemInfo = new Item(item, num, category, assignee);

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        TextView showItem = (TextView) convertView.findViewById(R.id.items);
        TextView showNum = (TextView) convertView.findViewById(R.id.amount);
        TextView showCategory = (TextView) convertView.findViewById(R.id.category);
        TextView showAssigned = (TextView) convertView.findViewById(R.id.assigned);

        showItem.setText(item);
        showNum.setText(num);
        showCategory.setText(category);
        showAssigned.setText(assignee);

        return convertView;
    }
}
