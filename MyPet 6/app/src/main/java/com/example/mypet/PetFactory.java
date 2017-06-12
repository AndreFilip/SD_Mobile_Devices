package com.example.mypet;

import java.util.ArrayList;
import java.util.List;

class PetFactory {

    static List<Pet> listOfPets;

    static  {
        listOfPets = new ArrayList<>();
        initializePets();
    }


    private PetFactory () {}

    private static void addPet (String PetName, String dateOfBirth, String sex, String breed, String colour, String distinguishingMarks, int chipId, String ownerName, String ownerAddress,
                                String ownerPhone, String VetName, String VetAddress, String VetPhone, String comments, int imageUri, String animals)
    {
        Pet pet = new Pet ( PetName,  dateOfBirth,  sex,  breed,  colour,  distinguishingMarks,  chipId,  ownerName,  ownerAddress,
                ownerPhone,  VetName,  VetAddress,  VetPhone,  comments,  imageUri , animals);
        listOfPets.add(pet);
    }

    private static void initializePets () {
        addPet("Liza", "15/3/2014", "F", "Labrador", "Blonde", "Missing tooth", 1, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a nice dog.", R.drawable.liza_dog, "dogs");
        addPet("Jaxon", "13/1/2005", "M", "Rotweiller", "Black", "Bigger one eye", 2, "Andreas Danikas", "Aristotelus 13", "2310524420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice dog.", R.drawable.jaxon_dog, "dogs");
        addPet("Laura", "5/1/2017", "F", "Canis", "Blonde", "Scarce on face", 3, "John Silver", "Aristotelus 23", "2310324620", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice dog.", R.drawable.liza_dog, "dogs");
        addPet("Peter", "18/9/2015", "M", "German Shepherd ", "Black", "Curved leg", 4, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice dog.", R.drawable.roni_dog, "dogs");
//        addPet("Rocky", "22/10/2011", "M", "Dalmatian", "Black", "Big tail", 5, "Eleanor Guthrie", "Aristotelus 43", "2310324289", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice dog.", R.drawable.jaxon_dog, "dogs");
//        addPet("Peter", "30/4/2012", "M", "Finnish Spitz", "Blonde", "-", 6, "Chris Paul", "Aristotelus 53", "2310324499", "John Nash", "Aristogitonos 42", "2310205570", "It's always a nice dog.", R.drawable.roni_dog, "dogs");
//        addPet("Gina", "5/1/2017", "F", "Canis", "Blonde", "Scarce on face", 7, "John Silver", "Aristotelus 23", "2310324620", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice dog.", R.drawable.liza_dog, "dogs");
//        addPet("Alex", "18/9/2008", "M", "German Shepherd ", "Black", "Curved leg", 8, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice dog.", R.drawable.roni_dog, "dogs");
        addPet("Liza", "15/3/2014", "F", "Cymric", "Brown", "Missing tooth", 11, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a very cat.", R.drawable.laura_cat_himalayan, "cats");
        addPet("Laura", "25/3/2014", "F", "Himalayan", "White", "Curved leg", 12, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a very nice cat.", R.drawable.mira_cat_cymric, "cats");
        addPet("Jaxon", "13/1/2005", "M", "Egyptian Mau", "Black", "Bigger one eye", 13, "Andreas Danikas", "Aristotelus 13", "2310524420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice cat.", R.drawable.bob_cat, "cats");
        addPet("Peter", "18/9/2015", "M", "Javanese ", "White", "Curved leg", 14, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice cat.", R.drawable.bob_cat, "cats");
//        addPet("Rocky", "22/10/2011", "M", "Persian", "Black", "Big tail", 15, "Eleanor Guthrie", "Aristotelus 43", "2310324289", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice cat.", R.drawable.laura_cat_himalayan, "cats");
//        addPet("Rita", "30/4/2012", "F", "Oriental", "Blonde", "-", 16, "Chris Paul", "Aristotelus 53", "2310324499", "John Nash", "Aristogitonos 42", "2310205570", "It's always a nice cat.", R.drawable.mira_cat_cymric, "cats");
//        addPet("Gina", "5/1/2017", "F", "Turkish Van", "Blonde", "Scarce on face", 17, "John Silver", "Aristotelus 23", "2310324620", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice cat.", R.drawable.laura_cat_himalayan, "cats");
//        addPet("Alex", "18/9/2008", "M", "Sphynx", "Black", "Curved leg", 18, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice cat.", R.drawable.bob_cat, "cats");
        addPet("Samy", "15/3/2014", "F", "Syrian", "Brown", "Missing tooth", 21, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a beautiful hamster.", R.drawable.samy_hamster, "hamsters");
        addPet("Peter", "25/3/2014", "F", "Chinese", "White", "Curved leg", 22, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a very nice hamster.", R.drawable.samy_hamster, "hamsters");
        addPet("Jaxon", "13/1/2005", "M", "Russian", "Black", "Bigger one eye", 23, "Andreas Danikas", "Aristotelus 13", "2310524420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice hamster.", R.drawable.samy_hamster,"hamsters");
        addPet("Samy", "18/9/2015", "M", "Campbell’s", "White", "Curved leg", 24, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice hamster.", R.drawable.samy_hamster, "hamsters");
//        addPet("Rocky", "22/10/2011", "M", "Roborovski", "Black", "Big tail", 25, "Eleanor Guthrie", "Aristotelus 43", "2310324289", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice hamster.", R.drawable.samy_hamster, "hamsters");
//        addPet("Rita", "30/4/2012", "F", "Dwarf", "Blonde", "-", 26, "Chris Paul", "Aristotelus 53", "2310324499", "John Nash", "Aristogitonos 42", "2310205570", "It's always a nice hamster.", R.drawable.samy_hamster, "hamsters");
//        addPet("Samy", "5/1/2017", "F", "Turkish Van", "Blonde", "Scarce on face", 27, "John Silver", "Aristotelus 23", "2310324620", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice hamster.", R.drawable.samy_hamster, "hamsters");
//        addPet("Alex", "18/9/2008", "M", "Russian", "Black", "Curved leg", 28, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice hamster.", R.drawable.samy_hamster,"hamsters");
        addPet("Peter", "25/3/2014", "F", "Lovebird", "White", "Curved leg", 32, "George Papadopoulos", "Aristotelus 3", "2310424420", "John Nash", "Aristogitonos 42", "2310205570", "It's a very nice parrot.", R.drawable.kimba_parrot, "parrots");
        addPet("Jaxon", "13/1/2005", "M", "Parrotlet", "Black", "Bigger one eye", 33, "Andreas Danikas", "Aristotelus 13", "2310524420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice parrot.", R.drawable.kimba_parrot, "parrots");
        addPet("Samy", "18/9/2015", "M", "Cockatoo", "White", "Curved leg", 34, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice parrot.", R.drawable.kimba_parrot, "parrots");
        addPet("Rocky", "22/10/2011", "M", "African Grey", "Black", "Big tail", 35, "Eleanor Guthrie", "Aristotelus 43", "2310324289", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice parrot.", R.drawable.kimba_parrot, "parrots");
//        addPet("Rita", "30/4/2012", "F", "Macaw", "Blonde", "-", 36, "Chris Paul", "Aristotelus 53", "2310324499", "John Nash", "Aristogitonos 42", "2310205570", "It's always a nice parrot.", R.drawable.kimba_parrot, "parrots");
//        addPet("Samy", "5/1/2017", "F", "Eclectu", "Blonde", "Scarce on face", 37, "John Silver", "Aristotelus 23", "2310324620", "Charles Vane", "Sintagmatos 8", "2310666670", "It's a very nice parrot.", R.drawable.kimba_parrot, "parrots");
//        addPet("Alex", "18/9/2008", "M", "Conure", "Black", "Talks too much", 38, "James Flint", "Aristotelus 33", "2310366420", "John Nash", "Aristogitonos 42", "2310205570", "It's not always a nice parrot.", R.drawable.kimba_parrot,"parrots");
    }

    static List<String> getPetCategories() {
        ArrayList<String> pets = new ArrayList<>();

        pets.add("dogs");
        pets.add("cats");
        pets.add("parrots");
        pets.add("hamsters");

        return pets;
    }

}

