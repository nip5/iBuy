package com.example.nathan_mccauslin.ibuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nate on 11/6/2017.
 */

public class MyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        onClickListenerButton();
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

}
