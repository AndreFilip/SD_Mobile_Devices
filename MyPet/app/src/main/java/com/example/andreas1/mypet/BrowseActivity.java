package com.example.andreas1.mypet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class BrowseActivity extends AppCompatActivity {

    public static final String EXTRA_PET_CATEGORY = "pet.category";
    public static final String EXTRA_FOR_STATUS = "status";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        int category = getIntent().getIntExtra(EXTRA_PET_CATEGORY, -1);
        boolean status = getIntent().getBooleanExtra(EXTRA_FOR_STATUS, false);

        FragmentPetChoice fragment = new FragmentPetChoice();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putInt(FragmentPetChoice.EXTRA_PET_CATEGORY2, category);
        args.putBoolean(FragmentPetChoice.EXTRA_FOR_STATUS2, status);
        fragment.setArguments(args);
        trans.replace(R.id.fragment_container, fragment);
        trans.commit();
        }
}
