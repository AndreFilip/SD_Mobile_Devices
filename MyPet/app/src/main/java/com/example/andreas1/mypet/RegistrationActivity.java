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

public class RegistrationActivity extends AppCompatActivity {

    public static final String KEY_FOR_STATUS = "key_for_status";

    private BroadcastReceiver createUserResultBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Boolean booleanResult = intent.getBooleanExtra(RegistrationActivity.KEY_FOR_STATUS, false);
            int response = intent.getIntExtra(UserService.EXTRA_MESSAGE_FROM_SERVER, -1);
            String username = intent.getStringExtra(UserService.EXTRA_KEY_FOR_USERNAME);

            Toast.makeText(RegistrationActivity.this, "Status: " + String.valueOf(booleanResult), Toast.LENGTH_LONG).show();
            Toast.makeText(RegistrationActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();

            if (booleanResult) {

                SharedPreferences preferences = getSharedPreferences(LogInActivity.SHARED_PREFERENCES_FILE, 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(LogInActivity.SHARED_PREFERENCES_FILE_KEY_USERNAME, username);
                editor.putBoolean(LogInActivity.SHARED_PREFERENCES_FILE_KEY_STATUS, true);
                editor.apply();

                Intent intent2 = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent2);
            }
            else {
                Toast.makeText(RegistrationActivity.this, "Didn't manage to register user", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button button_to_register = (Button) findViewById(R.id.button_to_register);

        button_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt_registry_username = (EditText) findViewById(R.id.edt_registry_username);
                EditText edt_registry_password = (EditText) findViewById(R.id.edt_registry_password);
                EditText edt_registry_confirm_password = (EditText) findViewById(R.id.edt_registry_confirm_password);
                EditText edt_registry_users_name = (EditText) findViewById(R.id.edt_registry_users_name);
                EditText edt_registry_users_surname = (EditText) findViewById(R.id.edt_registry_users_surname);

                String username = edt_registry_username.getText().toString();
                String password = edt_registry_password.getText().toString();
                String confirmedPassword = edt_registry_confirm_password.getText().toString();
                String nameOfUser = edt_registry_users_name.getText().toString().trim();
                String lastNameOfUser = edt_registry_users_surname.getText().toString().trim();

                if (password.length() < 6) {
                        edt_registry_password.setError("Must be at least 6 characters!");
                }
                else if (!password.equals(confirmedPassword)) {
                    edt_registry_confirm_password.setError("Password and confirmed password must be the same!");
                }
                else {
                    Intent intent = new Intent(RegistrationActivity.this, UserService.class);
                    intent.setAction(UserService.ACTION_CREATE_THE_USER);

                    intent.putExtra(UserService.EXTRA_NAME_OF_USER, nameOfUser);
                    intent.putExtra(UserService.EXTRA_LASTNAME_OF_USER, lastNameOfUser);
                    intent.putExtra(UserService.EXTRA_USERNAME, username);
                    intent.putExtra(UserService.EXTRA_PASSWORD, password);

                    startService(intent);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter createUserResultIntentFilter = new IntentFilter(UserService.ACTION_CREATE_USER_RESULT);
        broadcastManager.registerReceiver(createUserResultBroadcastReceiver, createUserResultIntentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastManager.unregisterReceiver(createUserResultBroadcastReceiver);
    }

}
