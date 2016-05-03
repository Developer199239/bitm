package com.bubtjobs.murtuza.filesystem;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Murtuza on 3/9/2016.
 */
public class ReadWrite {
    public ReadWrite() {

    }

    public boolean write(String dir, String input) {
        try {
            // FileInputStream fis = new FileInputStream(new File(""+dir));
            FileOutputStream fOut = new FileOutputStream("" + dir);
            OutputStreamWriter writer = new OutputStreamWriter(fOut);
            writer.write(input);
            writer.close();
            return true;

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return false;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    public String read(String dir) {
        try {
            FileInputStream fis = new FileInputStream(new File("" + dir));
            if (fis != null) {
                InputStreamReader reader = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String receivedText = "";
                StringBuilder builder = new StringBuilder();
                while ((receivedText = bufferedReader.readLine()) != null) {
                    builder.append(receivedText);
                }
                fis.close();

                return builder.toString();
            } else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}
