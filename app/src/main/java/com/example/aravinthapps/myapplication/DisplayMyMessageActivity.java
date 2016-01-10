package com.example.aravinthapps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMyMessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_my_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String ChkBox1 = bundle.getString("1");
        String ChkBox2 = bundle.getString("2");
        TextView textView = new TextView(this);
        TextView textView1 =  new TextView(this);
        textView.setTextSize(20);
        textView1.setTextSize(20);
        if(ChkBox1 != null) {
            textView.setText(ChkBox1);
        }
        else
        textView.setText(null);
        if(ChkBox2 !=null) {
            textView1.setText(ChkBox2);
        }
        else
        textView1.setText(null);
        LinearLayout layout = (LinearLayout)findViewById(R.id.content);
        layout.addView(textView);
        layout.addView(textView1);
    }

}
