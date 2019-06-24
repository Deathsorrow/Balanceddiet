package com.example.hp.balanceddiet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.hp.balanceddiet.adapter.MyListViewCursorAdapter;
import com.example.hp.balanceddiet.db.MyOpenHelper;
import com.example.hp.balanceddiet.utils.ToastUtils;


public class recipesActivity extends Activity implements AdapterView.OnItemClickListener{
    private EditText mEditText;
    private ImageView mImageView;
    private ListView mListView;
    private TextView mTextView;
    Context context;
    Cursor cursor;
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
        context = this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();
    }


    private void initView() {
        mTextView = (TextView) findViewById(R.id.textview);
        mEditText = (EditText) findViewById(R.id.edittext);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mListView = (ListView) findViewById(R.id.listview);

        //设置删除图片的点击事件
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //把EditText内容设置为空
                mEditText.setText("");
                //把ListView隐藏
                mListView.setVisibility(View.GONE);
            }
        });

        //EditText添加监听
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            //文本改变之前执行
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            //文本改变的时候执行
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //如果长度为0
                if (s.length() == 0) {
                    //隐藏“删除”图片
                    mImageView.setVisibility(View.GONE);
                    gview .setVisibility(View.VISIBLE);
                } else {//长度不为0
                    //显示“删除图片”
                    mImageView.setVisibility(View.VISIBLE);
                    gview.setVisibility(View.GONE);
                    //显示ListView
                    showListView();
                }
            }

            //文本改变之后执行
            public void afterTextChanged(Editable s) {
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果输入框内容为空，提示请输入搜索内容
                if(TextUtils.isEmpty(mEditText.getText().toString().trim())){
                    ToastUtils.showToast(context,"请输入您要搜索的菜谱");
                }else {
                    //判断cursor是否为空
                    if (cursor != null) {
                        int columnCount = cursor.getCount();
                        if (columnCount == 0) {
                            ToastUtils.showToast(context, "对不起，没有你要搜索的菜谱");
                        }
                    }
                }

            }
        });
    }

    private void showListView() {
        mListView.setVisibility(View.VISIBLE);

        //获得输入的内容
        String str = mEditText.getText().toString().trim();
        //获取数据库对象
        MyOpenHelper myOpenHelper = new MyOpenHelper(getApplicationContext());
        SQLiteDatabase db = myOpenHelper.getReadableDatabase();
        //得到cursor
        cursor = db.rawQuery("select * from lol where name like '%" + str + "%'", null);
        MyListViewCursorAdapter adapter = new MyListViewCursorAdapter(context, cursor);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把cursor移动到指定行
                cursor.moveToPosition(position);
                String name = cursor.getString(cursor.getColumnIndex("name"));
                ToastUtils.showToast(context, name);
            }
        });
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
