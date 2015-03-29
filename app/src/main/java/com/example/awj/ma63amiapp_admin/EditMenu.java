package com.example.awj.ma63amiapp_admin;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


public class EditMenu extends ActionBarActivity implements View.OnClickListener {
    Button b;
    TextView tv;
    EditText et;
    ProgressBar pg;
    String editText;
    String displayText;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        //Name Text control
        et = (EditText) findViewById(R.id.editText);
        //Display Text control
        tv = (TextView) findViewById(R.id.textView);
        //Button to trigger web service invocation
        b = (Button) findViewById(R.id.button);
        //Display progress bar until web service invocation completes
        pg = (ProgressBar) findViewById(R.id.progressBar);
        //Button Click Listener
        ArrayList<String> items = new ArrayList<String>();
        items.add("a");
        items.add("v");
        items.add("c");
        items.add("b");
        items.add("e");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        ListView ItemsView = (ListView) findViewById(R.id.ItemsList);
        ItemsView.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Check if Name text control is not empty
                if (et.getText().length() != 0 && et.getText().toString() != "") {
                    //Get the text control value
                    editText = et.getText().toString();
                    //Create instance for AsyncCallWS
                    AsyncCallWS task = new AsyncCallWS();
                    //Call execute
                    task.execute();
                    //If text control is empty
                } else {
                    tv.setText("Please enter name");
                }
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            displayText = WebService1.invokeHelloWorldWS(editText,"sayHello");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            tv.setText(displayText);
            //Make ProgressBar invisible
            pg.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPreExecute() {
            //Make ProgressBar invisible
            pg.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        ImageView addItem = (ImageView) findViewById(R.id.addItem);
        addItem.setOnClickListener(this);
        ImageView editItem = (ImageView) findViewById(R.id.editItem);
        editItem.setOnClickListener(this);
        ImageView  back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);

        String []items = {"cocacola","banana","sandwishs","water",
        "falafel","humos","bread","mealk","shoklet"};



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        ListView ItemsView = (ListView) findViewById(R.id.ItemsList);
        ItemsView.setAdapter(adapter);
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_menu, menu);
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
        if(v.getId() == R.id.back) {
            finish();
        }
        else if(v.getId() == R.id.addItem) {
            startActivity(new Intent(EditMenu.this,addItem.class));
        }
        else if(v.getId() == R.id.editItem) {
            startActivity(new Intent(EditMenu.this,editItem.class));
        }
    }
}
