package com.example.andreas1.mypet;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class FragmentPetChoice extends Fragment {

    private ListView listView;

    private BaseAdapter adapter;
    public static List<Pet> pets;

    public static final String EXTRA_PET_CATEGORY2 = "pet.category";
    public static final String EXTRA_FOR_STATUS2 = "status2";

    private int category;
    private boolean status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pet_choice_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        category = getArguments().getInt(EXTRA_PET_CATEGORY2);
        status = getArguments().getBoolean(EXTRA_FOR_STATUS2);

        if (category == 1) {
            pets = PetFactory.listOfDogs;
        } else if (category == 2) {
            pets = PetFactory.listOfCats;
        } else if (category == 3) {
            pets = PetFactory.listOfParrots;
        } else {
            pets = PetFactory.listOfHamsters;
        }

        adapter = new PetAdapter(getActivity(), pets);

        listView = (ListView) getActivity().findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setVisibility(View.VISIBLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              if (!status) {
                  Toast.makeText(getActivity(), "Details are only available to registered users.", Toast.LENGTH_SHORT).show();
              }
              else {
                  Intent intent = new Intent(getActivity(), DetailsActivity.class);
                  intent.putExtra(DetailsActivity.EXTRA_KEY_FOR_INDEX, position);
                  intent.putExtra(DetailsActivity.EXTRA_KEY_FOR_CATEGORY, category);
                  startActivity(intent);
              }
           }
        });

    }
}
