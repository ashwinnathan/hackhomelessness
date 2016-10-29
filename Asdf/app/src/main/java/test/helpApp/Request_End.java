package test.helpApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import test.asdf.R;

/**
 * Created by jzou on 9/24/16.
 */
public class Request_End extends AppCompatActivity implements View.OnClickListener{


    private Button homebutton;
    private Button anotherbutton;

    private GoogleApiClient client;
    private DatabaseReference firebaseRef;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    private static final String TAG = "New Post Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.req_end);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        homebutton = (Button)findViewById(R.id.homebutton);
        homebutton.setOnClickListener(this);
        anotherbutton = (Button)findViewById(R.id.anotherbutton);
        anotherbutton.setOnClickListener(this);
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
        if ( view == homebutton)
        {
            startActivity(new Intent(this,MainActivity.class));
        }
        if(view == anotherbutton)
        {
            startActivity(new Intent(this, Request_Choices.class));
        }
    }

}
