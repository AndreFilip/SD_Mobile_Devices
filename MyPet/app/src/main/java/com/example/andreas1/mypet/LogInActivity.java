package com.example.andreas1.mypet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    static final String SHARED_PREFERENCES_FILE = "my.preferences.file";
    static final String SHARED_PREFERENCES_FILE_KEY_USERNAME = "username.preferences.file";
    static final String SHARED_PREFERENCES_FILE_KEY_STATUS = "status.preferences.file";

    private BroadcastReceiver getUserResultBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Boolean booleanResult = intent.getBooleanExtra(RegistrationActivity.KEY_FOR_STATUS,false);
            int response = intent.getIntExtra(UserService.EXTRA_MESSAGE_FROM_SERVER, -1);
            String username = intent.getStringExtra(UserService.EXTRA_KEY_FOR_USERNAME);

            Toast.makeText(LogInActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();

            if (booleanResult) {
                SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(SHARED_PREFERENCES_FILE_KEY_USERNAME, username);
                editor.putBoolean(SHARED_PREFERENCES_FILE_KEY_STATUS, true);
                editor.apply();

                Intent intent2 = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent2);
            }
            else {
                Toast.makeText(LogInActivity.this, "Didn't manage to log in.", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button button_go_register = (Button) findViewById(R.id.button_go_register);
        Button button_log_in = (Button) findViewById(R.id.button_log_in);

        button_go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


        button_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edt_username = (EditText) findViewById(R.id.edt_username);
                EditText edt_password = (EditText) findViewById(R.id.edt_password);
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();

                Intent intent = new Intent(LogInActivity.this, UserService.class);
                intent.setAction(UserService.ACTION_GET_THE_USER);

                intent.putExtra(UserService.EXTRA_TEST_USERNAME, username);
                intent.putExtra(UserService.EXTRA_TEST_PASSWORD, password);

                startService(intent);
         }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter getUserResultIntentFilter = new IntentFilter(UserService.ACTION_GET_USER_RESULT);
        broadcastManager.registerReceiver(getUserResultBroadcastReceiver, getUserResultIntentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastManager.unregisterReceiver(getUserResultBroadcastReceiver);
    }

}



