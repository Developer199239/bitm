package com.bubtjobs.murtuza.filesystem;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by Murtuza on 3/9/2016.
 */
public class CreateDirectory {
    public CreateDirectory() {

    }

    public String create() {

        File myFile = new File("/sdcard/jalilur.txt");
        try {
            myFile.createNewFile();
            return myFile.toString();
        } catch (IOException e) {
            return "1";
        }
    }
}
