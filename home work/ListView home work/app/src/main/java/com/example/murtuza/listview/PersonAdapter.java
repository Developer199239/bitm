package com.example.murtuza.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Murtuza on 3/5/2016.
 */
public class PersonAdapter  extends ArrayAdapter<Person>{
    ArrayList<Person> personArrayList;
    Context context;

    public PersonAdapter(Context context, ArrayList<Person>personArrayList) {
        super(context,R.layout.custom_row,personArrayList);
        this.context=context;
        this.personArrayList=personArrayList;
    }

    static class ViewHolder{
        TextView nameTx;
        TextView phoneTx;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
      if (convertView==null){
          LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView=layoutInflater.inflate(R.layout.custom_row,null);

          viewHolder=new ViewHolder();
          viewHolder.nameTx=(TextView)convertView.findViewById(R.id.name);
          viewHolder.phoneTx=(TextView)convertView.findViewById(R.id.phone);
          viewHolder.image=(ImageView)convertView.findViewById(R.id.image);
          convertView.setTag(viewHolder);
      }
        else{
          viewHolder=(ViewHolder)convertView.getTag();
      }


        viewHolder.nameTx.setText(personArrayList.get(position).getName());
        viewHolder.phoneTx.setText(personArrayList.get(position).getPhone());
        viewHolder.image.setImageResource(personArrayList.get(position).getImage());

        return  convertView;
    }
}
