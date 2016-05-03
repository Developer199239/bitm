package jalilur.bitm.listview.explicit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView,textBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.TextView);
        textBundle=(TextView)findViewById(R.id.textView1);
        String empty[];
         String data[]=getIntent().getStringArrayExtra("array");
        String s="";

        if(data!=null) {
            for (int i = 0; i < data.length; i++) {
                s = s + data[i] + "\n";
            }
            textView.setText(s);

        }


        Bundle getBundle = getIntent().getExtras();
        getBundle = this.getIntent().getExtras();
        if (getBundle != null) {
           String value = getBundle.getString("key");
           if (value!=null)
               textBundle.setText(value);
        }
    }


}
