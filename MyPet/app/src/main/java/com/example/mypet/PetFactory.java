package com.example.mypet;

import java.util.ArrayList;
import java.util.List;

class PetFactory {

    private static List<Pet> listOfPets = new ArrayList<>() ;

    private PetFactory () {

    }

    private static void add (int PetNameResId, int PetBreedResId ) {
        Pet pet = new Pet(PetNameResId, PetBreedResId);
        listOfPets.add(pet);
    }

    private static void initialize () {
        add(R.string.pet_name_1, R.string.pet_breed_1) ;
        add(R.string.pet_name_2, R.string.pet_breed_2) ;
        add(R.string.pet_name_3, R.string.pet_breed_3) ;
    }

    static List<Pet> getListOfPets() {
        initialize();
        return listOfPets;
    }


}
