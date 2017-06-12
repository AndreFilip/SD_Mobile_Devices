package com.example.mypet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private SQLiteDatabase database;
//    PetDBSchemaHelper help;

    private static final String[] PROJECTIONS = {PetDBSchema.PetTable.NAME, PetDBSchema.PetTable.BREED, PetDBSchema.PetTable.IMAGE_URI};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        help = MainActivity.getHelper();

        getDesiredPets();

        Button btnDetails = (Button) findViewById(R.id.btn_for_details);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
    }

    //code for accessing database
    private void getDesiredPets() {
        database = MainActivity.helper.getReadableDatabase();

        Cursor cursor = database.query(PetDBSchema.PetTable.TABLE_NAME, PROJECTIONS, null, null, null, null, null);
        String results = "";

        while (cursor.moveToNext()) {

            String NAME = cursor.getString(cursor.getColumnIndex(PetDBSchema.PetTable.NAME));
            String BREED = cursor.getString(cursor.getColumnIndex(PetDBSchema.PetTable.BREED));
            int IMAGE_URI = cursor.getInt(cursor.getColumnIndex(PetDBSchema.PetTable.IMAGE_URI));

            results += IMAGE_URI + "\t" + NAME + "\t" + BREED + "\n";
        }

        TextView resultsTextView = (TextView) findViewById(R.id.view_for_database_results);
        resultsTextView.setText(results);

        cursor.close();
    }

}