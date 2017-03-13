package com.example.mypet;


public class Pet {

    private int mPetNameResId;
    private int mPetBreedResId;


    public Pet (int PetNameResId, int PetBreedResId ) {
        mPetNameResId  = PetNameResId;
        mPetBreedResId = PetBreedResId;
    }


    public int getPetNameResId() {
        return mPetNameResId;
    }

    public void setPetNameResId(int petNameResId) {
        mPetNameResId = petNameResId;
    }

    public int getPetBreedResId() {
        return mPetBreedResId;
    }

    public void setPetBreedResId(int petBreedResId) {
        mPetBreedResId = petBreedResId;
    }


}
