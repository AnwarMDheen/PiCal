package com.example.navi_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int selectedtab=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout gstLayout=findViewById(R.id.gstLayout);
        final LinearLayout UnitLayout=findViewById(R.id.UnitConvert);
        final LinearLayout NumLayout=findViewById(R.id.NumberSystem);
        final LinearLayout ScifiLayout=findViewById(R.id.SciFi);

        final ImageView gstImage=findViewById(R.id.gstimg);
        final ImageView unitimage=findViewById(R.id.Unitimg);
        final ImageView NumImage=findViewById(R.id.Numimg);
        final ImageView scifiImage=findViewById(R.id.scifiimg);

        final TextView gsttxt=findViewById(R.id.gsttxt);
        final TextView unittxt=findViewById(R.id.Unittxt);
        final TextView Numtxt=findViewById(R.id.numtxt);
        final TextView Scifitxt=findViewById(R.id.Scifitxt);

        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmentContainer,GstFragment.class,null)
                                        .commit();



        gstLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer,GstFragment.class,null)
                        .commit();


                if(selectedtab!=1){
                    unittxt.setVisibility(View.GONE);
                    Numtxt.setVisibility(View.GONE);
                    Scifitxt.setVisibility(View.GONE);

                    unitimage.setImageResource(R.drawable.unit_con);
                    NumImage.setImageResource(R.drawable.num_con);
                    scifiImage.setImageResource(R.drawable.scientific);

                    UnitLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    NumLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    ScifiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    gsttxt.setVisibility(View.VISIBLE);
                    gstImage.setImageResource(R.drawable.gst_selected);
                    gstLayout.setBackgroundResource(R.drawable.round_back_gst);

                    ScaleAnimation scaleanimation= new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleanimation.setDuration(200);
                    scaleanimation.setFillAfter(true);
                    gstLayout.startAnimation(scaleanimation);

                    selectedtab=1;


                }
            }
        });

        UnitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedtab!=2){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,UnitFragment.class,null)
                            .commit();


                    gsttxt.setVisibility(View.GONE);
                    Numtxt.setVisibility(View.GONE);
                    Scifitxt.setVisibility(View.GONE);

                    gstImage.setImageResource(R.drawable.gst);
                    NumImage.setImageResource(R.drawable.num_con);
                    scifiImage.setImageResource(R.drawable.scientific);

                    gstLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    NumLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    ScifiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    unittxt.setVisibility(View.VISIBLE);
                    unitimage.setImageResource(R.drawable.unit_con_selected);
                    UnitLayout.setBackgroundResource(R.drawable.round_back_gst);

                    ScaleAnimation scaleanimation= new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleanimation.setDuration(200);
                    scaleanimation.setFillAfter(true);
                    UnitLayout.startAnimation(scaleanimation);

                    selectedtab=2;


                }

            }
        });

        NumLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedtab!=3){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,NumFragment.class,null)
                            .commit();


                    gsttxt.setVisibility(View.GONE);
                    unittxt.setVisibility(View.GONE);
                    Scifitxt.setVisibility(View.GONE);

                    gstImage.setImageResource(R.drawable.gst);
                    unitimage.setImageResource(R.drawable.unit_con);
                    scifiImage.setImageResource(R.drawable.scientific);

                    gstLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    UnitLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    ScifiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    Numtxt.setVisibility(View.VISIBLE);
                    NumImage.setImageResource(R.drawable.num_con_selected);
                    NumLayout.setBackgroundResource(R.drawable.round_back_gst);

                    ScaleAnimation scaleanimation= new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleanimation.setDuration(200);
                    scaleanimation.setFillAfter(true);
                    NumLayout.startAnimation(scaleanimation);

                    selectedtab=3;


                }
            }
        });

        ScifiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedtab!=4){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,ScifiFragment.class,null)
                            .commit();


                    gsttxt.setVisibility(View.GONE);
                    unittxt.setVisibility(View.GONE);
                    Numtxt.setVisibility(View.GONE);

                    gstImage.setImageResource(R.drawable.gst);
                    unitimage.setImageResource(R.drawable.unit_con);
                    NumImage.setImageResource(R.drawable.num_con);

                    gstLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    UnitLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    NumLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    Scifitxt.setVisibility(View.VISIBLE);
                    scifiImage.setImageResource(R.drawable.scientific_selected);
                    ScifiLayout.setBackgroundResource(R.drawable.round_back_gst);

                    ScaleAnimation scaleanimation= new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleanimation.setDuration(200);
                    scaleanimation.setFillAfter(true);
                    ScifiLayout.startAnimation(scaleanimation);

                    selectedtab=4;


                }
            }
        });


    }
}