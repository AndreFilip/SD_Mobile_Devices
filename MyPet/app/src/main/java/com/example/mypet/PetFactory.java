package com.example.mypet;

import java.util.ArrayList;
import java.util.List;

class PetFactory {

    private static List<Pet> listOfDogs = new ArrayList<>();
    private static List<Pet> listOfCats = new ArrayList<>();
    private static List<Pet> listOfHamsters = new ArrayList<>();
    private static List<Pet> listOfParrots = new ArrayList<>() ;

    private PetFactory () {

    }

    private static void addDog (int PetName,int PetAnimal, int PetBreed, int PetSex, int PetColour, int PetDateOfBirth, int PetOwner, int image) {
        Pet pet = new Pet(PetName,PetAnimal, PetBreed, PetSex,PetColour, PetDateOfBirth, PetOwner, image);
        listOfDogs.add(pet);
    }

    private static void addCat(int PetName,int PetAnimal, int PetBreed, int PetSex, int PetColour, int PetDateOfBirth, int PetOwner, int image) {
        Pet pet = new Pet(PetName,PetAnimal, PetBreed, PetSex,PetColour, PetDateOfBirth, PetOwner, image);
        listOfCats.add(pet);
    }

    private static void addHamster (int PetName,int PetAnimal, int PetBreed, int PetSex, int PetColour, int PetDateOfBirth, int PetOwner, int image) {
        Pet pet = new Pet(PetName,PetAnimal, PetBreed, PetSex,PetColour, PetDateOfBirth, PetOwner, image);
        listOfHamsters.add(pet);
    }

    private static void addParrot (int PetName,int PetAnimal, int PetBreed, int PetSex, int PetColour, int PetDateOfBirth, int PetOwner, int image) {
        Pet pet = new Pet(PetName,PetAnimal, PetBreed, PetSex,PetColour, PetDateOfBirth, PetOwner, image);
        listOfParrots.add(pet);
    }

    private static void initializeDogs () {
        addDog(R.string.liza, R.string.dog,R.string.labrador ,R.string.female,R.string.blonde, R.string.date_liza,R.string.owner1, R.drawable.liza_dog);
        addDog(R.string.jaxon, R.string.dog,R.string.rotweiller ,R.string.male,R.string.black, R.string.date_jaxon,R.string.owner11, R.drawable.jaxon_dog);
        addDog(R.string.roni, R.string.dog,R.string.beagle ,R.string.male,R.string.brown, R.string.date_roni,R.string.owner12, R.drawable.roni_dog);
        addDog(R.string.laura, R.string.dog,R.string.labrador ,R.string.female,R.string.blonde, R.string.date_liza,R.string.owner1, R.drawable.liza_dog);
        addDog(R.string.jaxon, R.string.dog,R.string.rotweiller ,R.string.male,R.string.black, R.string.date_jaxon,R.string.owner11, R.drawable.jaxon_dog);
        addDog(R.string.mira, R.string.dog,R.string.beagle ,R.string.male,R.string.brown, R.string.date_roni,R.string.owner12, R.drawable.roni_dog);
    }

    private static void initializeCats () {
        addCat(R.string.bob,  R.string.cat, R.string.american_shorthair ,R.string.male,R.string.grey, R.string.date_bob,R.string.owner2, R.drawable.bob_cat);
        addCat(R.string.mira,  R.string.cat, R.string.cymric ,R.string.female,R.string.brown, R.string.date_mira,R.string.owner21, R.drawable.mira_cat_cymric);
        addCat(R.string.laura,  R.string.cat, R.string.himalayan ,R.string.female,R.string.white, R.string.date_laura,R.string.owner22, R.drawable.laura_cat_himalayan);
        addCat(R.string.samy,  R.string.cat, R.string.himalayan ,R.string.female,R.string.white, R.string.date_laura,R.string.owner22, R.drawable.laura_cat_himalayan);
        addCat(R.string.laura,  R.string.cat, R.string.himalayan ,R.string.female,R.string.white, R.string.date_laura,R.string.owner22, R.drawable.laura_cat_himalayan);
        addCat(R.string.mira,  R.string.cat, R.string.cymric ,R.string.female,R.string.brown, R.string.date_mira,R.string.owner21, R.drawable.mira_cat_cymric);

    }

    private static void initializeHamsters () {
        addHamster(R.string.samy, R.string.hamster,R.string.syrian ,R.string.male,R.string.white, R.string.date_samy,R.string.owner3, R.drawable.samy_hamster);
        addHamster(R.string.mira, R.string.hamster,R.string.american_shorthair ,R.string.male,R.string.white, R.string.date_samy,R.string.owner31, R.drawable.samy_hamster);
        addHamster(R.string.laura, R.string.hamster,R.string.syrian ,R.string.male,R.string.white, R.string.date_samy,R.string.owner2, R.drawable.samy_hamster);
        addHamster(R.string.liza, R.string.hamster,R.string.american_shorthair ,R.string.male,R.string.white, R.string.date_samy,R.string.owner31, R.drawable.samy_hamster);
        addHamster(R.string.bob, R.string.hamster,R.string.syrian ,R.string.male,R.string.white, R.string.date_samy,R.string.owner1, R.drawable.samy_hamster);
        addHamster(R.string.samy, R.string.hamster,R.string.cymric ,R.string.male,R.string.white, R.string.date_samy,R.string.owner31, R.drawable.samy_hamster);
    }

    private static void initializeParrots () {
        addParrot(R.string.kimba, R.string.parrot,R.string.cockatiel ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner3, R.drawable.kimba_parrot);
        addParrot(R.string.bob, R.string.parrot,R.string.syrian ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner31, R.drawable.kimba_parrot);
        addParrot(R.string.liza, R.string.parrot, R.string.cymric ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner2, R.drawable.kimba_parrot);
        addParrot(R.string.kimba, R.string.parrot,R.string.cockatiel ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner3, R.drawable.kimba_parrot);
        addParrot(R.string.roni, R.string.parrot,R.string.cymric,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner31, R.drawable.kimba_parrot);
        addParrot(R.string.kimba, R.string.parrot,R.string.cockatiel ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner3, R.drawable.kimba_parrot);
        addParrot(R.string.samy, R.string.parrot,R.string.syrian ,R.string.female,R.string.grey, R.string.date_kimba,R.string.owner3, R.drawable.kimba_parrot);
    }

    static List<Pet> getListOfDogs() {
        initializeDogs();
        return listOfDogs;
    }

    static List<Pet> getListOfCats() {
        initializeCats();
        return listOfCats;
    }

    static List<Pet> getListOfHamsters() {
        initializeHamsters();
        return listOfHamsters;
    }

    static List<Pet> getListOfParrots() {
        initializeParrots();
        return listOfParrots;
    }

    static List<String> getPetCategories() {
        ArrayList<String> pets = new ArrayList<>();

        pets.add("Dogs");
        pets.add("Cats");
        pets.add("Parrots");
        pets.add("Hamsters");

        return pets;
    }

}

