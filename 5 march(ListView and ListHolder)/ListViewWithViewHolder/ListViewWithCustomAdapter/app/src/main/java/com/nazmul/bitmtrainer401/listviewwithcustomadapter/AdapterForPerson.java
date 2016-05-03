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
    private ArrayList<PersonModel> personModelArrayList;
    private Context context;

    public AdapterForPerson(Context context, ArrayList<PersonModel> personModelArrayList) {
        super(context, R.layout.custom_row, personModelArrayList);
        this.context = context;
        this.personModelArrayList = personModelArrayList;
    }

    static class ViewHolder {
        TextView nameTV;
        TextView locationTV;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, null);

            viewHolder = new ViewHolder();
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.nameTextView);
            viewHolder.locationTV = (TextView) convertView.findViewById(R.id.locationTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.nameTV.setText(personModelArrayList.get(position).getName());
        viewHolder.locationTV.setText(personModelArrayList.get(position).getLocation());

        return convertView;
    }
}
