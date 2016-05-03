package com.example.bitmtrainer401.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BITM Trainer 401 on 3/22/2016.
 */
public class Fragment2 extends Fragment{

    public Fragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2,container,false);
    }


}
