package com.example.andreas1.mypet;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentCategoryChoice extends Fragment {

    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onCategorySelected(int category);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentInteractionListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_choice_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button dogs = (Button) getActivity().findViewById(R.id.buttonDogs);
        Button cats = (Button) getActivity().findViewById(R.id.buttonCats);
        Button parrots = (Button) getActivity().findViewById(R.id.buttonParrots);
        Button hamsters =  (Button) getActivity().findViewById(R.id.buttonHamsters);

        dogs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onCategorySelected(1);
            }
        });
        cats.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onCategorySelected(2);
            }
        });
        parrots.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onCategorySelected(3);
            }
        });
        hamsters.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onCategorySelected(4);
            }
        });
    }
}
