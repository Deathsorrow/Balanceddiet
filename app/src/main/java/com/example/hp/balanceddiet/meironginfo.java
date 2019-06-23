package com.example.hp.balanceddiet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


public class meironginfo extends AppCompatActivity {
    Button image=null;
    Button back=null;
    TextView name=null;
    TextView foodinfo=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meironginfo);
        Bundle bundle=getIntent().getExtras();
        int drawable=bundle.getInt("drawable");
        String foodname=bundle.getString("foodname");
        String foodinfos=bundle.getString("foodinfo");
        image=findViewById(R.id.BTmeirong);
        image.setBackgroundResource(drawable);
        name=findViewById(R.id.namemeirong);
        name.setText(foodname);
        foodinfo=(TextView)findViewById(R.id.TVmeirong);
        foodinfo.setText(foodinfos);
        back=(Button)findViewById(R.id.backinfo);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button)v;
                Intent intent=new Intent(meironginfo.this,meirong.class);
                startActivity(intent);
            }
        });

        if(foodname.equals("苦瓜醸肉馅")) {
            ViewPager viewPager = (ViewPager) findViewById(R.id.vpmeirong);
            MyPageAdapter pageAdapter = new MyPageAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pageAdapter);

            TabLayout tabLayout = findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(viewPager);
        }else if(foodname.equals("山药莲子炖乌鸡")){
            ViewPager viewPager = (ViewPager) findViewById(R.id.vpmeirong);
            shanyaoPageAdapter pageAdapter = new shanyaoPageAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pageAdapter);

            TabLayout tabLayout = findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(viewPager);
        }else if(foodname.equals("板栗百合煲鸡脚")){
            ViewPager viewPager = (ViewPager) findViewById(R.id.vpmeirong);
            banliPagerAdapter pageAdapter = new banliPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pageAdapter);

            TabLayout tabLayout = findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(viewPager);
        }


    }


}
