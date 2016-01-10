package com.example.aravinthapps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1,ch2;
    String chkBox1 = null,chkBox2 = null;
    Bundle bundle = new Bundle();
    public final static String EXTRA_MESSAGE = "com.example.aravinthapps.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ch1 = (CheckBox)findViewById(R.id.chkBox1);
        ch2 = (CheckBox)findViewById(R.id.chkBox2);
        Button b1 = (Button)findViewById(R.id.button_send);
        b1.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {
                sendMessage(v);
            }
        });
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

    public void oncheckBoxClicked(View view)
    {
        Boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId())
        {
            case R.id.chkBox1:
                if(checked) {
                    chkBox1 = ch1.getText().toString();
                    bundle.putString("1", chkBox1);
                    bundle.putString("2",chkBox2);
                }
                else {
                    bundle.putString("1", null);
                    bundle.putString("2", chkBox2);
                }
                break;
            case R.id.chkBox2:
                if(checked) {
                    chkBox2 = ch2.getText().toString();
                    bundle.putString("2", chkBox2);
                    bundle.putString("1", chkBox1);
                }
                else {
                    bundle.putString("1", chkBox1);
                    bundle.putString("2", null);
                }
                break;
            default:
                bundle.putString("1", chkBox1);
                bundle.putString("2", chkBox2);
                break;

        }

    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this,DisplayMyMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
