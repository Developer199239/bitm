package troublesome.bitm.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);

        final String[] name={"Jalilur","Rahman","Murtuza","Tonmoy","Saker","Anik","Kumar","Sojon","Khurshed","Alam","Rakib","Nirjhore","Mahabub","Mahi","Mithun","Kumar","Halder"};


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item_row,R.id.text,name);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,name[position],Toast.LENGTH_SHORT).show();
            }
        });

    }

}
