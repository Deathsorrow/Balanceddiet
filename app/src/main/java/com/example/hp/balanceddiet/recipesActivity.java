package com.example.hp.balanceddiet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class recipesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icons = {R.drawable.meirong,R.drawable.jianfei,R.drawable.yangsheng,R.drawable.buru,R.drawable.tiandian,R.drawable.waiguo};
    private String[] iconName ={"排毒养颜","减肥健身","保健养身","孕产哺乳","甜点饮品","外国美食"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        gview = (GridView) findViewById(R.id.gview);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item, from, to);
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(this);
    }

    public List<Map<String, Object>> getData(){
        for(int i=0;i<icons.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icons[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    public void back2(View btn){
        Intent main = new Intent(this,MainActivity.class);
        startActivity(main);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0){
        Intent intent=new Intent(this,meirong.class);
        startActivity(intent);}
    }
}
