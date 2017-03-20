package com.example.mypet;

import java.util.ArrayList;
import java.util.List;

class PetFactory {

    private static List<Pet> listOfPets = new ArrayList<>() ;

    private PetFactory () {

    }

    private static void add (int PetName,int PetAnimal, int PetBreed, int PetSex, int PetColour, int PetDateOfBirth, int PetOwner, int image) {
        Pet pet = new Pet(PetName,PetAnimal, PetBreed, PetSex,PetColour, PetDateOfBirth, PetOwner, image);
        listOfPets.add(pet);
    }

    private static void initialize () {
        add(R.string.bob,  R.string.cat, R.string.american_shorthair ,R.string.male,R.string.grey, R.string.date_bob,R.string.owner1, R.drawable.bob_cat);
        add(R.string.liza, R.string.dog,R.string.labrador ,R.string.female,R.string.blonde, R.string.date_liza,R.string.owner2, R.drawable.liza_dog);
        add(R.string.kimba, R.string.parrot,R.string.cockatiel ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner3, R.drawable.kimba_parrot);
    }

    static List<Pet> getListOfPets() {
        initialize();
        return listOfPets;
    }


}

