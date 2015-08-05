package com.example.irenachernyak.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.Console;

import static android.util.Log.*;


public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        try {
            ActionBar ab = getActionBar();
            if(ab != null) {
                getActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_HOME | android.app.ActionBar.DISPLAY_SHOW_TITLE);
                getActionBar().setIcon(R.mipmap.ic_launcher);
                Log.i("onCreate", "using ActionBar");

            } else {
                getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
                getSupportActionBar().setIcon(R.mipmap.ic_launcher);
                Log.i("onCreate", "using SupportActionBar");
            }
        } catch(Exception e) {
            Log.e("OnCreate", e.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_search:
//                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void openSettings()
    {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }

    public void SendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
