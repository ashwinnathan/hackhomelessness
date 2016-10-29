package test.helpApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.ImageButton;

import test.asdf.R;

/**
 * Created by ashwinnathan on 9/24/16.
 */

public class GiveInfo extends AppCompatActivity implements View.OnClickListener {

    private ImageButton eventbutton;
    private ImageButton mentorbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        eventbutton = (ImageButton)findViewById(R.id.eventbutton);
        eventbutton.setOnClickListener(this);
        mentorbutton=(ImageButton)findViewById(R.id.mentorbutton);
        mentorbutton.setOnClickListener(this);
        setSupportActionBar(toolbar);

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
        if ( view == eventbutton){
            startActivity(new Intent(this,Give_OrgList.class));
        }
        if(view == mentorbutton)
        {
            startActivity(new Intent(this, Give_Indlist.class));
        }
    }
}
