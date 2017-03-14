package com.example.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mPetNameView;
    private TextView mPetBreedView;;

    private int currentIndex = 0;

    private List<Pet> pets = PetFactory.getListOfPets();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPetNameView = (TextView) findViewById(R.id.pet_name_view);
        mPetBreedView = (TextView) findViewById(R.id.pet_breed_view);
        displayTextViews();

        ImageButton mArrowLeft = (ImageButton) findViewById(R.id.arrow_left);
        mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < 0) { currentIndex = pets.size() - 1;}
                displayTextViews();
                currentIndex = currentIndex - 1;
            }
        });

        ImageButton mArrowRight =  (ImageButton) findViewById(R.id.arrow_right);
        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % pets.size();
                displayTextViews();
            }
        });
    }

     private void displayTextViews() {
         mPetNameView.setText(pets.get(currentIndex).getPetNameResId());
         mPetBreedView.setText(pets.get(currentIndex).getPetBreedResId());
     }

}
