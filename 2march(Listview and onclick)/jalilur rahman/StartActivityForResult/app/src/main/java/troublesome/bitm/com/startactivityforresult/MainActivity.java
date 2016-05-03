package troublesome.bitm.com.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView showTx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTx=(TextView)findViewById(R.id.resultShowTx);
    }
    public void showResult(View view){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 2:
                String message=data.getStringExtra("message");
                showTx.setText(message);
                break;
            default:
                break;
        }
    }
}
