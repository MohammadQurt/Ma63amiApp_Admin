package com.example.awj.ma63amiapp_admin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;


public class editItem extends ActionBarActivity implements View.OnClickListener {
    ArrayList<String> []catigories=null;
    int numOfCatigories = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        catigories=  new ArrayList[5];
        for(int i=0;i<numOfCatigories;i++)
            catigories[i] = new ArrayList<String>();

        Spinner category =  (Spinner)findViewById(R.id.category);
        String[] items = new String[]{"Drinks", "Bizza", "cooked food","Sandwiches"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        category.setAdapter(adapter);

        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cancel) {
            finish();
        }
    }
}
