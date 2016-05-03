package troublesome.bitm.com.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText messageEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        messageEt=(EditText)findViewById(R.id.messageEt);
    }

    public void sendResult(View view){
        Intent intent=new Intent();
        intent.putExtra("message",messageEt.getText().toString());
        setResult(2,intent);
        finish();
    }

}
