package com.example.mypet;

import android.provider.BaseColumns;

public final class PetDBSchema {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private PetDBSchema() {}

    public static abstract class PetTable implements BaseColumns {
        public static final String TABLE_NAME = "pets";

        public static final String NAME = "name";
        public static final String DATE_OF_BIRTH = "date_of_birth";
        public static final String GENDER = "gender";
        public static final String BREED = "breed";
        public static final String COLOUR = "colour";
        public static final String DISTINGUISHING_MARKS = "distinguishing_marks";
        public static final String CHIP_ID = "chip_id";
        public static final String OWNER_NAME = "owner_name";
        public static final String OWNER_ADDRESS = "owner_address";
        public static final String OWNER_PHONE = "owner_phone";
        public static final String VET_NAME = "vet_name";
        public static final String VET_ADDRESS = "vet_address";
        public static final String VET_PHONE = "vet_phone";
        public static final String COMMENTS = "comments";
        public static final String IMAGE_URI = "image_uri";
    }

    static final String SQL_CREATE_PETS = "CREATE TABLE " + PetDBSchema.PetTable.TABLE_NAME + " (" + PetDBSchema.PetTable._ID +  INT_TYPE + " PRIMARY KEY AUTOINCREMENT," + PetDBSchema.PetTable.NAME + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.DATE_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
            PetDBSchema.PetTable.GENDER + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.BREED + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.COLOUR + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.DISTINGUISHING_MARKS + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.CHIP_ID + INT_TYPE + COMMA_SEP +
            PetDBSchema.PetTable.OWNER_NAME + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.OWNER_ADDRESS + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.OWNER_PHONE + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.VET_NAME + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.VET_ADDRESS + TEXT_TYPE + COMMA_SEP +
            PetDBSchema.PetTable.VET_PHONE + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.COMMENTS + TEXT_TYPE + COMMA_SEP + PetDBSchema.PetTable.IMAGE_URI + INT_TYPE + " )";

    static final String SQL_DELETE_PETS = "DROP TABLE IF EXISTS " + PetDBSchema.PetTable.TABLE_NAME;
}
