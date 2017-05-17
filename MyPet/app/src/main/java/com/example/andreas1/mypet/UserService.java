package com.example.andreas1.mypet;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserService extends IntentService {

    public static final String EXTRA_NAME_OF_USER = "first.name";
    public static final String EXTRA_LASTNAME_OF_USER = "last.name";
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_PASSWORD = "password";

    public static final String ACTION_CREATE_THE_USER = "action create user";
    public static final String ACTION_GET_THE_USER = "action get user";

    public static final String ACTION_CREATE_USER_RESULT = "action create user result";
    public static final String ACTION_GET_USER_RESULT = "action get user result";

    public static final String EXTRA_USER_RESULT = "user result";
    public static final String EXTRA_USER_RESULT_ERROR = "Nothing found.";
    public static final String EXTRA_MESSAGE_FROM_SERVER = "message";
    public static final String EXTRA_KEY_FOR_USERNAME = "username";

    private static final String GET_USER_URL = "http://hodor.ait.gr:8080/myPets/api/user/";
    private static final String CREATE_USER_URL = "http://hodor.ait.gr:8080/myPets/api/user/";

    public static final String EXTRA_TEST_USERNAME = "extra.test.username";
    public static final String EXTRA_TEST_PASSWORD = "extra.test.password";

    public UserService() {
        super("User Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if (ACTION_CREATE_THE_USER.equals(action)) {
            createUser(intent);
        } else if (ACTION_GET_THE_USER.equals(action)) {
            getTheUser(intent);
        } else {
            throw new UnsupportedOperationException("No implementation for action " + action);
        }
    }

    private void createUser(Intent intent) {

        try {
            String username = intent.getStringExtra(EXTRA_USERNAME);
            String password = intent.getStringExtra(EXTRA_PASSWORD);
            String nameOfUser = intent.getStringExtra(EXTRA_NAME_OF_USER);
            String lastNameOfUser = intent.getStringExtra(EXTRA_LASTNAME_OF_USER);

            String stringURL = CREATE_USER_URL;
            URL url = new URL(stringURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.addRequestProperty("Content-Type", "application/json");

            User user = new User(username, password, nameOfUser, lastNameOfUser);
            String userJson = new Gson().toJson(user);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            writer.write(userJson);
            writer.flush();
            writer.close();

            conn.getOutputStream().close();

            conn.connect();

            int response = conn.getResponseCode();
            Intent resultIntent = new Intent(ACTION_CREATE_USER_RESULT);

            if (response >= 200 && response < 300 ) {
                resultIntent.putExtra(RegistrationActivity.KEY_FOR_STATUS, true);
                resultIntent.putExtra(EXTRA_MESSAGE_FROM_SERVER, response);
                resultIntent.putExtra(EXTRA_KEY_FOR_USERNAME, username);

            }else {
                resultIntent.putExtra(RegistrationActivity.KEY_FOR_STATUS, false);
                resultIntent.putExtra(EXTRA_MESSAGE_FROM_SERVER, response);
            }
            LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
        }
        catch (Exception e)
        {
            Intent resultIntent = new Intent(ACTION_CREATE_USER_RESULT);
            resultIntent.putExtra(RegistrationActivity.KEY_FOR_STATUS, false);
            LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
        }
    }

    private void getTheUser(Intent intent) {
        InputStream is = null;

        try {
            String username = intent.getStringExtra(EXTRA_TEST_USERNAME);
            String password = intent.getStringExtra(EXTRA_TEST_PASSWORD);
            String stringURL = GET_USER_URL + username  + "/" +  password ;

            URL url = new URL(stringURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            conn.connect();
            int response = conn.getResponseCode();

            is = conn.getInputStream();

            String user = convertStreamToString(is);
            User registeredUser = new Gson().fromJson(user, User.class);

            if (username.equals(registeredUser.getUserName()) && password.equals(registeredUser.getPassword()) && (response >= 200 && response < 300))
            {
                Intent resultIntent = new Intent(ACTION_GET_USER_RESULT);
                resultIntent.putExtra(RegistrationActivity.KEY_FOR_STATUS, true);
                resultIntent.putExtra(EXTRA_MESSAGE_FROM_SERVER, response);
                resultIntent.putExtra(EXTRA_KEY_FOR_USERNAME, registeredUser.getUserName());

                LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
            }
            else {
                Intent resultIntent = new Intent(ACTION_GET_USER_RESULT);
                resultIntent.putExtra(RegistrationActivity.KEY_FOR_STATUS, false);
                resultIntent.putExtra(EXTRA_MESSAGE_FROM_SERVER, response);
                LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
            }

        } catch (Exception e)
        {
            Intent resultIntent = new Intent(ACTION_GET_USER_RESULT);
            resultIntent.putExtra(EXTRA_USER_RESULT, EXTRA_USER_RESULT_ERROR);
            LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String convertStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }

        return baos.toString();
    }
}


































