package test.asdf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jzou on 9/24/16.
 */
public class Give_OrgSelect extends AppCompatActivity implements View.OnClickListener, ValueEventListener{


    private Button confirmbutton;

    private GoogleApiClient client;
    private DatabaseReference firebaseRef;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private static final String TAG = "New Post Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.give_orgselect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        confirmbutton = (Button)findViewById(R.id.confirm);
        confirmbutton.setOnClickListener(this);
        setSupportActionBar(toolbar);
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                CheckBox text1 = (CheckBox)findViewById(R.id.checkBox1);
                CheckBox text2 = (CheckBox)findViewById(R.id.checkBox2);
                CheckBox text3 = (CheckBox)findViewById(R.id.checkBox3);
                CheckBox text4 = (CheckBox)findViewById(R.id.checkBox4);
                CheckBox text5 = (CheckBox)findViewById(R.id.checkBox5);
                CheckBox[] checks = {text1, text2, text3, text4, text5};
                int count = 1;
                /*for( child : dataSnapshot.getValue())
                {
                    String[] ar = (String[])child;
                    checks[count].setText(ar[2]);
                    checks[count].setVisibility(View.VISIBLE);

                    count++;

                }*/
                text5.setText(count+"");
                text5.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

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
        if ( view == confirmbutton){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
