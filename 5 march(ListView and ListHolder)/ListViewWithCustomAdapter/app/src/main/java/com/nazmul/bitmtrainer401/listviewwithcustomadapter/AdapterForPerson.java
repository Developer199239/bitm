package com.nazmul.bitmtrainer401.listviewwithcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BITM Trainer 401 on 3/5/2016.
 */
public class AdapterForPerson extends ArrayAdapter<PersonModel> {
    private ArrayList<PersonModel>personModelArrayList;
    private Context context;
    public AdapterForPerson(Context context, ArrayList<PersonModel> personModelArrayList) {
        super(context, R.layout.custom_row,personModelArrayList);
        this.context=context;
        this.personModelArrayList=personModelArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.custom_row,null);
        TextView nameTV= (TextView) view.findViewById(R.id.nameTextView);
        TextView locationTV= (TextView) view.findViewById(R.id.locationTextView);
        nameTV.setText(personModelArrayList.get(position).getName());
        locationTV.setText(personModelArrayList.get(position).getLocation());
        return view;
    }
}
