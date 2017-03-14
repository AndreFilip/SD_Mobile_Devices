package com.example.mypet;


 class Pet {

    private int mPetNameResId;
    private int mPetBreedResId;

     Pet (int petNameResId, int petBreedResId ) {
        mPetNameResId  = petNameResId;
        mPetBreedResId = petBreedResId;
     }

     void setPetNameResId(int petNameResId) {
        mPetNameResId = petNameResId;
     }

     int getPetNameResId()     {
         return mPetNameResId;
     }

     void setPetBreedResId(int petBreedResId) {
         mPetBreedResId = petBreedResId;
     }

     int getPetBreedResId() {
        return mPetBreedResId;
     }

 }
