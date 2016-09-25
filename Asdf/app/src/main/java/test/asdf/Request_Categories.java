package test.asdf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Map;
import java.util.HashMap;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rohit on 9/25/2016.
 */

public class Request_Categories extends AppCompatActivity implements View.OnClickListener{
    private Button submit;

    private EditText item;

    private GoogleApiClient client;
    private DatabaseReference firebaseRef;
    String name;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    private static final String TAG = "New Post Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.req_cate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        submit = (Button)findViewById(R.id.submitbutton);
        item = (EditText)findViewById(R.id.clothing);
        submit.setOnClickListener(this);
        name =  ((GlobalVar) this.getApplication()).getGlobalVarValue();
        myRef = database.getReference(name);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view)
    {
        if ( view == submit){
            Map<String, String> map = new HashMap<String, String>();
            map.put("hehe xd",item.getText().toString());
            myRef.setValue(map);
            myRef.push();
            startActivity(new Intent(this,Request_End.class));
        }
    }

}

