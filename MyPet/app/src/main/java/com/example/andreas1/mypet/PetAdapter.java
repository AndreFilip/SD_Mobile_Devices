package com.example.andreas1.mypet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PetAdapter extends BaseAdapter {

    private Context context;
    private List<Pet> pets;

    public PetAdapter(Context context, List<Pet> pets) {
        this.context = context;
        this.pets = pets;
    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Object getItem(int position) {
        return pets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.layout_item, parent, false);
        }

        Pet pet = (Pet) getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.pet_name_view_layout_item);
        TextView breedTextView = (TextView) convertView.findViewById(R.id.pet_breed_view_layout_item);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view_layout_item);

        imageView.setImageResource(pet.getImageUri());
        nameTextView.setText(pet.getPetName());
        breedTextView.setText(pet.getBreed());

        return convertView;

    }
}
