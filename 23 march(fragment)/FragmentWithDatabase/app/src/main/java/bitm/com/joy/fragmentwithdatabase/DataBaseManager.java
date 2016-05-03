package bitm.com.joy.fragmentwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


/**
 * Created by Murtuza on 3/15/2016.
 */
public class DataBaseManager {
    private DataBaseHelper helper;
    private SQLiteDatabase database;
    Context context;


    public DataBaseManager(Context context){
        helper=new DataBaseHelper(context);
        this.context=context;
    }

    private void open(){
        database=helper.getWritableDatabase();
    }

    private void close(){
        helper.close();
    }

   public boolean addStudent(StudentList input){
       try{
           this.open();
           ContentValues contentValues = new ContentValues();
           contentValues.put(DataBaseHelper.NAME,input.getUserName());
           contentValues.put(DataBaseHelper.NAME,input.getUserEmail());
           long inserted = database.insert(DataBaseHelper.TABLE_STUDENTINFO, null, contentValues);
           this.close();
           if(inserted>0)
           {
             return true;
           }
           else{
               return false;
           }

       }
       catch (Exception e)
       {
           return false;
       }
   }

    public ArrayList<StudentList> getAllStudent(){
        ArrayList<StudentList> list=new ArrayList<>();
        try{

            this.open();

            String sql = "select * from " + DataBaseHelper.TABLE_STUDENTINFO;

            Cursor cursor = database.rawQuery(sql, null);
            cursor.moveToFirst();

            if (cursor != null && cursor.getCount() > 0) {
                for(int i=0;i<cursor.getCount();i++) {
                    String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME));
                    String email = cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL));

                    StudentList  studentList= new StudentList(name, email);
                    list.add(studentList);
                    cursor.moveToNext();
                }
            }

            this.close();

            return list;
        }
        catch (Exception e)
        {
            return list;
        }



    }


}
