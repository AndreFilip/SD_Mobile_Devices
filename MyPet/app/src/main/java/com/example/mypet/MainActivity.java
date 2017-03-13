package com.example.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton mArrowLeft;
    private ImageButton mArrowRight;
    private TextView mPetNameView;
    private TextView mPetBreedView;

    private int currentIndex = 0;

    private Pet[] pets = new Pet[] {
            new Pet (R.string.pet_name_1 ,R.string.pet_breed_1),
            new Pet (R.string.pet_name_2 ,R.string.pet_breed_2),
            new Pet (R.string.pet_name_3 ,R.string.pet_breed_3)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPetNameView = (TextView) findViewById(R.id.pet_name_view);
        mPetNameView.setText(pets[currentIndex].getPetNameResId());

        mPetBreedView = (TextView) findViewById(R.id.pet_breed_view);
        mPetBreedView.setText(pets[currentIndex].getPetBreedResId());


        mArrowLeft = (ImageButton)findViewById(R.id.arrow_left);
        mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex - 1 < 0) { currentIndex = pets.length -1;}

                int nextName = pets[currentIndex].getPetNameResId();
                int nextBreed = pets[currentIndex].getPetBreedResId();

                mPetNameView.setText(nextName);
                mPetBreedView.setText(nextBreed);

                currentIndex = (currentIndex - 1);
            }
        });

        mArrowRight =  (ImageButton) findViewById(R.id.arrow_right);
        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % pets.length;
                int nextName = pets[currentIndex].getPetNameResId();
                int nextBreed = pets[currentIndex].getPetBreedResId();

                mPetNameView.setText(nextName);
                mPetBreedView.setText(nextBreed);
            }
        });
    }
}
