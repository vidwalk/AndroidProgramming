package com.example.android.pets;

import android.provider.BaseColumns;

public final class PetsContract {
    private  PetsContract() {}

    public class PetEntry implements BaseColumns{
        public static final String TABLE_NAME = "pets";

        public static final String ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_WEIGHT = "weight";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
