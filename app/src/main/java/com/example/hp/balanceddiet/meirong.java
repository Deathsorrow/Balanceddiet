package com.example.hp.balanceddiet;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class meirong extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView  mListView;
    private static final String[] food = { "苦瓜醸肉馅", "山药莲子炖乌鸡", "板栗百合煲鸡脚"};
    private static final String[] food1 = { "原料：苦瓜、肉末、鸡蛋、盐、味精、生抽、白糖、醋、酱油、姜等。",
            "原料：乌鸡手枪腿、山药、莲子、枸杞、水等。", "原料：新鲜鸡脚、板栗、百合、生姜、蜜枣、盐等。"};
    private static final int[] resId = { R.drawable.meirong1, R.drawable.meirong2, R.drawable.meirong3};
    private  static final String[] foodjianjie={"夏天炎热，吃苦瓜清热解毒，是一道必不可少的夏日好菜。苦瓜醸肉馅既好看又好吃，用蒸的方式使得此道菜品健康营养！",
    "味道鲜美外而且汤水很清晰， 跟煲出来的汤不一样; 莲子除了用来做甜汤外， 也可以用来煲汤; 其实只要活用材料， 做出来的料理自然美味。尤其是女性，喝了可以滋补养颜。",
    "板栗性温味甘,功能养胃健脾,补肾强筋。鸡脚富含胶原、骨类粘蛋白等,有健筋骨、滋胃液、滑皮肤、助血脉、固肾壮骨之功。多吃不但能软化血管，同时具有美容功效，增强皮肤张力、消除皱纹的功效。"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meirong);
        mListView=(ListView)findViewById(R.id.lv_meirong);
        mListView.setAdapter(new MyBaseAdapter());
        mListView.setOnItemClickListener(this);
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return food.length;
        }

        @Override
        public Object getItem(int position) {
            return food[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view = View.inflate(meirong.this, R.layout.meirong_list, null);//在list_item中有两个id,现在要把他们拿过来
            TextView title = (TextView) view.findViewById(R.id.itemTitlem);
            TextView detail = (TextView) view.findViewById(R.id.itemDetailm);
            ImageView imageView = (ImageView) view.findViewById(R.id.photom);
            //组件一拿到，开始组装
            title.setText(food[position]);
            detail.setText(food1[position]);
            imageView.setBackgroundResource(resId[position]);
            //组装玩开始返回
            return view;
        }
    }

    public void backp(View btn){
        Intent main = new Intent(this,recipesActivity.class);
        startActivity(main);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent();
        intent.setClass(this, meironginfo.class);
        intent.putExtra("drawable", resId[position]);
        intent.putExtra("foodname", food[position]);
        intent.putExtra("foodinfo", foodjianjie[position]);
        startActivity(intent);
    }
}
