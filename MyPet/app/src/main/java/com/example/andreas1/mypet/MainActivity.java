package com.example.andreas1.mypet;

import android.content.SharedPreferences;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private BaseAdapter adapter;
    private List<Pet> pets = PetFactory.listOfPets;

    private boolean registrationStatus;
    private String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(LogInActivity.SHARED_PREFERENCES_FILE, 0);
        registrationStatus = preferences.getBoolean(LogInActivity.SHARED_PREFERENCES_FILE_KEY_STATUS, false);
        currentUsername = preferences.getString(LogInActivity.SHARED_PREFERENCES_FILE_KEY_USERNAME, "No username");
        Toast.makeText(MainActivity.this, currentUsername + " is currently logged in.", Toast.LENGTH_SHORT).show();

        adapter = new PetAdapter(this, pets);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setVisibility(View.VISIBLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!registrationStatus) {
                    Toast.makeText(MainActivity.this, "Details are only available to registered users.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent (MainActivity.this, BrowseActivity.class);
                    intent.putExtra(BrowseActivity.EXTRA_KEY_FOR_INDEX, position);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_login_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_login:
                Intent intent = new Intent (MainActivity.this, LogInActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_logout:
                SharedPreferences preferences = getSharedPreferences(LogInActivity.SHARED_PREFERENCES_FILE, 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent2 = getIntent();
                finish();
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.menu_login).setVisible(!registrationStatus);
        menu.findItem(R.id.menu_logout).setVisible(registrationStatus);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(LogInActivity.SHARED_PREFERENCES_FILE, 0);
        registrationStatus = preferences.getBoolean(LogInActivity.SHARED_PREFERENCES_FILE_KEY_STATUS, false);
        currentUsername = preferences.getString(LogInActivity.SHARED_PREFERENCES_FILE_KEY_USERNAME,"No username");
        Toast.makeText(MainActivity.this, currentUsername + " is currently logged in.", Toast.LENGTH_SHORT).show();;
    }
}


