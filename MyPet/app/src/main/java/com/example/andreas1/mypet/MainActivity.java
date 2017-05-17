package com.example.andreas1.mypet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentCategoryChoice.OnFragmentInteractionListener {

    private boolean registrationStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCategorySelected(int category) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        boolean isDualPane = fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FragmentPetChoice fragment = new FragmentPetChoice();
            Bundle args = new Bundle();
            args.putInt(FragmentPetChoice.EXTRA_PET_CATEGORY2, category);
            args.putBoolean(FragmentPetChoice.EXTRA_FOR_STATUS2, registrationStatus);
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(this, BrowseActivity.class);
            intent.putExtra(BrowseActivity.EXTRA_PET_CATEGORY, category);
            intent.putExtra(BrowseActivity.EXTRA_FOR_STATUS, registrationStatus);
            startActivity(intent);
        }
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
        //String currentUsername = preferences.getString(LogInActivity.SHARED_PREFERENCES_FILE_KEY_USERNAME,"No username");
        //Toast.makeText(MainActivity.this, currentUsername + " is currently logged in.", Toast.LENGTH_SHORT).show();
    }

}
