package com.example.mob.uichicago;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewFlipper imageFlip;
    private Button back, next, about, contact, apply, yes;
    private TextView description, uic;
    private ImageView sparky;

    String URL = "https://admissions.uic.edu/apply-now";
    Intent i = new Intent(Intent.ACTION_VIEW);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFlip = (ViewFlipper) findViewById(R.id.imageSwitcher);
        back = (Button) findViewById(R.id.back);
        next = (Button) findViewById(R.id.next);
        about = (Button) findViewById(R.id.aboutID);
        contact = (Button) findViewById(R.id.contactID);
        apply = (Button) findViewById(R.id.applyID);
        yes = (Button) findViewById(R.id.yesID);
        description = (TextView) findViewById(R.id.descriptionID);
        uic = (TextView) findViewById(R.id.uicID);
        sparky = (ImageView) findViewById(R.id.sparkyID);

        next.setOnClickListener(this);
        back.setOnClickListener(this);
        about.setOnClickListener(this);
        contact.setOnClickListener(this);
        apply.setOnClickListener(this);
        yes.setOnClickListener(this);

        i.setData(Uri.parse(URL));
    }
    @Override
    public void onClick(View v) {
        if (v == next) imageFlip.showNext();

        else if (v == back) imageFlip.showPrevious();

        else if (v == about) {
            uic.setText("University of Illinois at Chicago:");
            description.setText("\tLocated in the heart of one of the world’s great cities, the University of Illinois at Chicago is a vital part of the educational, technological and cultural fabric of the region. As Chicago’s only public research university with 30,000 students, 15 colleges, a hospital and a health sciences system, UIC provides you access to excellence and opportunity.");

            description.setGravity(Gravity.LEFT);
            yes.setVisibility(View.INVISIBLE);
            sparky.setVisibility(View.INVISIBLE);
        }

        else if (v == contact) {
            uic.setText("University of Illinois at Chicago: ");
            description.setText("\tAddress:\n\t\t1200 W Harrison St, \n\t\tChicago, IL \n\t\t60607\n\n\tAdmissions and Records:\n\t\tuicadmit@uic.edu\n\t\t312-996-4350\n\n\tFinancial Aid\n\t\tmoney@uic.edu\n\t\t312-996-3126");

            description.setGravity(Gravity.LEFT);
            yes.setVisibility(View.INVISIBLE);
            sparky.setVisibility(View.INVISIBLE);
        }

        else if (v == apply) {
            uic.setText("Ready to be a Pyromaniac and become one of the Flames? Apply Now!");
            description.setText("");

            description.setGravity(Gravity.LEFT);
            yes.setVisibility(View.VISIBLE);
            sparky.setVisibility(View.VISIBLE);
        }

        else if (v == yes) startActivity(i);
    }


}
