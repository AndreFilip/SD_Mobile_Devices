package com.example.mypet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    static final String EXTRA_KEY = "";

    private PetDBSchemaHelper helper;

    private static final String[] PROJECTIONS = {PetDBSchema.PetTable.NAME, PetDBSchema.PetTable.BREED, PetDBSchema.PetTable.IMAGE_URI};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        SQLiteDatabase database;
        helper = new PetDBSchemaHelper(this);

        database = helper.getWritableDatabase();
        database.execSQL(PetDBSchema.SQL_DELETE_PETS);
        database.execSQL(PetDBSchema.SQL_CREATE_PETS);

        if (getIntent().getStringExtra(EXTRA_KEY).equalsIgnoreCase("dogs")) {
            addDogsToDb();
        }
        if (getIntent().getStringExtra(EXTRA_KEY).equalsIgnoreCase("cats")) {
            addCatsToDb();
        }
        if (getIntent().getStringExtra(EXTRA_KEY).equalsIgnoreCase("hamsters")) {
            addHamstersToDb();
        }
        if (getIntent().getStringExtra(EXTRA_KEY).equalsIgnoreCase("parrots")) {
            addParrotsToDb();
        }

        getAllPets();

        Button btnDetails = (Button) findViewById(R.id.btn_for_details);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
    }

    public PetDBSchemaHelper getHelper() {
        return helper;
    }

    //code for adding to database
    private ContentValues getContentValues(Pet p) {
        ContentValues values = new ContentValues();

        values.put(PetDBSchema.PetTable.NAME, p.getPetName());
        values.put(PetDBSchema.PetTable.DATE_OF_BIRTH, p.getDateOfBirth());
        values.put(PetDBSchema.PetTable.GENDER, p.getSex());
        values.put(PetDBSchema.PetTable.BREED, p.getBreed());
        values.put(PetDBSchema.PetTable.COLOUR, p.getColour());
        values.put(PetDBSchema.PetTable.DISTINGUISHING_MARKS, p.getDistinguishingMarks());
        values.put(PetDBSchema.PetTable.CHIP_ID, p.getChipId());
        values.put(PetDBSchema.PetTable.OWNER_NAME, p.getOwnerName());
        values.put(PetDBSchema.PetTable.OWNER_ADDRESS, p.getOwnerAddress());
        values.put(PetDBSchema.PetTable.OWNER_PHONE, p.getOwnerPhone());
        values.put(PetDBSchema.PetTable.VET_NAME, p.getVetName());
        values.put(PetDBSchema.PetTable.VET_ADDRESS, p.getVetAddress());
        values.put(PetDBSchema.PetTable.VET_PHONE, p.getVetPhone());
        values.put(PetDBSchema.PetTable.COMMENTS, p.getComments());
        values.put(PetDBSchema.PetTable.IMAGE_URI, p.getImageUri());

        return values;
    }

    private void insertPet(Pet p) {
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = getContentValues(p);
        database.insert(PetDBSchema.PetTable.TABLE_NAME, null, values);
    }

    private void addDogsToDb() {
        List<Pet> listOfPets = PetFactory.getListOfDogs();
        for (Pet p : listOfPets) {
            insertPet(p);
        }
    }

    private void addCatsToDb() {
        List<Pet> listOfPets = PetFactory.getListOfCats();
        for (Pet p : listOfPets) {
            insertPet(p);
        }
    }

    private void addHamstersToDb() {
        List<Pet> listOfPets = PetFactory.getListOfHamsters();
        for (Pet p : listOfPets) {
            insertPet(p);
        }
    }

    private void addParrotsToDb() {
        List<Pet> listOfPets = PetFactory.getListOfParrots();
        for (Pet p : listOfPets) {
            insertPet(p);
        }
    }

    //code for accessing database
    private void getAllPets() {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(PetDBSchema.PetTable.TABLE_NAME, PROJECTIONS, null, null, null, null, null);
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

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }


}