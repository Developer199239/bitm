package bitm.com.joy.fragmentwithdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Murtuza on 3/15/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    static final int DATABASE_VERSION=1;
    static final String DATABSE_NAME="bitm_registration";

    // table name
    static final String TABLE_STUDENTINFO="student_info";


    /****************************** variable *************************/
    static final String COL_ID="id";
    static final String NAME="name";
    static final String  EMAIL="email";

    // table student info
    static final String CREATE_TABLE_SUDENTINFO=" CREATE TABLE "+TABLE_STUDENTINFO+" ( "+COL_ID+" INTEGER PRIMARY KEY,"+
            NAME+" TEXT,"+ EMAIL+" TEXT )";

    public DataBaseHelper(Context context) {
        super(context,DATABSE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SUDENTINFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

