package com.stackBuffers.ipl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    Context context;
    CardView  mLiveScore,mSchedule,mPointTable,mTeams,mRecentMatches,aboutus;


   /* Toolbar mToolbar;
    DrawerLayout drawerLayout;
    ImageView mNav;
    RelativeLayout mLiveScore,mSchedule,mPointTable,mTeams,mVenues,mRecentMatches;*/

    //SliderView sliderView;
    // SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intiView();
       /* sliderView = findViewById(R.id.imageSlider);
      sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);
       sliderLayout.addSliderView(sliderView)
        setSliderView();*/




      /*  mNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });*/



        mLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,LiveScoreActivity.class);
                startActivity(intent);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });

        mSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,SechdualActivity.class);
                startActivity(i);
            }
        });

        mPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,PointTableActivity.class);
                startActivity(i);
            }
        });

        mRecentMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,RecentmatchesActivity.class);
                startActivity(i);
            }
        });
        mTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,TeamsActivity.class);
                startActivity(i);
            }
        });





    }

    private void intiView() {

        context = this;
        mLiveScore = findViewById(R.id.home_liveScore);
        mSchedule = findViewById(R.id.home_schedule);
        mPointTable = findViewById(R.id.home_pointTable);
        mRecentMatches = findViewById(R.id.home_recentMatches);
        mTeams = findViewById(R.id.home_teams);
        aboutus = findViewById(R.id.home_aboutus);

    }
}





