package com.example.murtuza.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonViewDetails extends AppCompatActivity {
    ImageView imageView;
    TextView nameTv,phoneTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_view_details);
        String name=getIntent().getStringExtra("name");
        String phone=getIntent().getStringExtra("phone");
        int  image=getIntent().getIntExtra("image", 0);
        imageView=(ImageView)findViewById(R.id.imageView);
        nameTv=(TextView)findViewById(R.id.nameTV);
        phoneTv=(TextView)findViewById(R.id.phoneTv);

        imageView.setImageResource(image);
        nameTv.setText(name);
        phoneTv.setText(phone);

    }
}
