package com.example.andreas1.mypet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    private ImageView mImageView;

    private TextView mPetNameView;
    private TextView mPetDateOfBirthView;
    private TextView mPetSexView;
    private TextView mPetBreedView;
    private TextView mPetColourView;
    private TextView pet_distinguishing_marks_view;
    private TextView pet_chip_id_view;
    private TextView mPetOwnerView;
    private TextView pet_owner_address_view;
    private TextView pet_owner_phone_view;
    private TextView pet_vet_name_view;
    private TextView pet_vet_address_view;
    private TextView pet_vet_pnone_view;

    private int currentIndex = 0;
    static final String EXTRA_KEY_FOR_INDEX = "extra_key_for_index";
    private static final String KEY_FOR_INDEX = "key_for_index";

    private List<Pet> pets = PetFactory.listOfPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        if (savedInstanceState == null) {
            currentIndex = getIntent().getIntExtra(EXTRA_KEY_FOR_INDEX, 0);
        }

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_FOR_INDEX, 0);
        }

        mImageView = (ImageView) findViewById(R.id.image_view);

        mPetNameView = (TextView) findViewById(R.id.pet_name_view);
        mPetDateOfBirthView = (TextView) findViewById(R.id.pet_date_of_birth_view);
        mPetSexView = (TextView) findViewById(R.id.pet_sex_view);
        mPetBreedView = (TextView) findViewById(R.id.pet_breed_view);
        mPetColourView = (TextView) findViewById(R.id.pet_colour_view);
        pet_distinguishing_marks_view = (TextView) findViewById(R.id.pet_distinguishing_marks_view);
        pet_chip_id_view = (TextView) findViewById(R.id.pet_chip_id_view);
        mPetOwnerView = (TextView) findViewById(R.id.pet_name_owner_view);
        pet_owner_address_view = (TextView) findViewById(R.id.pet_owner_address_view);
        pet_owner_phone_view = (TextView) findViewById(R.id.pet_owner_phone_view);
        pet_vet_name_view = (TextView) findViewById(R.id.pet_vet_name_view);
        pet_vet_address_view = (TextView) findViewById(R.id.pet_vet_address_view);
        pet_vet_pnone_view = (TextView) findViewById(R.id.pet_vet_pnone_view);

        ImageButton mArrowLeft =  (ImageButton) findViewById(R.id.arrow_left);
        mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = currentIndex - 1;
                if (currentIndex < 0) { currentIndex = pets.size() - 1;}
                displayViews();

            }
        });

        ImageButton mArrowRight =  (ImageButton) findViewById(R.id.arrow_right);
        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % pets.size();
                displayViews();
            }
        });

        displayViews();

    }

    private void displayViews() {

        mImageView.setImageResource(pets.get(currentIndex).getImageUri());

        mPetNameView.setText(pets.get(currentIndex).getPetName());
        mPetDateOfBirthView.setText(pets.get(currentIndex).getDateOfBirth());
        mPetSexView.setText(pets.get(currentIndex).getSex());
        mPetBreedView.setText(pets.get(currentIndex).getBreed());
        mPetColourView.setText(pets.get(currentIndex).getColour());
        pet_distinguishing_marks_view.setText(pets.get(currentIndex).getDistinguishingMarks());
        pet_chip_id_view.setText(String.valueOf(pets.get(currentIndex).getChipId()));
        mPetOwnerView.setText(pets.get(currentIndex).getOwnerName());
        pet_owner_address_view.setText(pets.get(currentIndex).getOwnerAddress());
        pet_owner_phone_view.setText(pets.get(currentIndex).getOwnerPhone());
        pet_vet_name_view.setText(pets.get(currentIndex).getVetName());
        pet_vet_address_view.setText(pets.get(currentIndex).getVetAddress());
        pet_vet_pnone_view.setText(pets.get(currentIndex).getVetPhone());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_FOR_INDEX, currentIndex);
    }

}
