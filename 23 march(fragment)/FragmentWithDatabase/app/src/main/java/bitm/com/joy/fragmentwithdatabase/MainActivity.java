package bitm.com.joy.fragmentwithdatabase;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button insertBt,listBt;

    Fragment currentFragment;

    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentFragment=new InsertFragment();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.myFragment, currentFragment);
        transaction.commit();
    }


}
