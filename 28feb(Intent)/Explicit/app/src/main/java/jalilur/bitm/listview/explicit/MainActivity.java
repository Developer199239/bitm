package jalilur.bitm.listview.explicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEt=(EditText)findViewById(R.id.editText);
    }

    public void sendData(View view){
        String[] data=new String[3];
        data[0]=textEt.getText().toString();
        data[1]="Hello";
        data[2]="Bitm";
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("array", data);
        startActivity(intent);

    }

    public  void sendDataInBundle(View view){

        Bundle bundle = new Bundle();
        bundle.putString("key","This is bundle");
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
