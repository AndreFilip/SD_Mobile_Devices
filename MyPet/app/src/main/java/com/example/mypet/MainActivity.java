package com.example.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    private TextView mPetNameView;
    private TextView mPetAnimalView;
    private TextView mPetBreedView;
    private TextView mPetSexView;;
    private TextView mPetColourView;;
    private TextView mPetDateOfBirthView;;
    private TextView mPetOwnerView;;

    private int currentIndex = 0;
    private static final String KEY_INDEX = "theCurrentIndex";

    private List<Pet> pets = PetFactory.getListOfPets();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mImageView = (ImageView) findViewById(R.id.image_view);

        mPetNameView = (TextView) findViewById(R.id.pet_name_view);
        mPetAnimalView = (TextView) findViewById(R.id.pet_animal_view);
        mPetBreedView = (TextView) findViewById(R.id.pet_breed_view);
        mPetSexView = (TextView) findViewById(R.id.pet_sex_view);
        mPetColourView = (TextView) findViewById(R.id.pet_colour_view);
        mPetDateOfBirthView = (TextView) findViewById(R.id.pet_date_of_birth_view);
        mPetOwnerView = (TextView) findViewById(R.id.pet_name_owner_view);

        displayViews();

        ImageButton mArrowLeft = (ImageButton) findViewById(R.id.arrow_left);
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
    }

     private void displayViews() {

         mImageView.setImageResource(pets.get(currentIndex).getImageId());

         mPetNameView.setText(pets.get(currentIndex).getPetNameId());
         mPetAnimalView.setText(pets.get(currentIndex).getPetAnimalId());
         mPetBreedView.setText(pets.get(currentIndex).getPetBreedId());
         mPetSexView.setText(pets.get(currentIndex).getPetSexId());
         mPetColourView.setText(pets.get(currentIndex).getPetColourId());
         mPetDateOfBirthView.setText(pets.get(currentIndex).getPetDateOfBirthId());
         mPetOwnerView.setText(pets.get(currentIndex).getPetOwnerId());
     }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, currentIndex);
    }
}
