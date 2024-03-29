package com.example.hp.balanceddiet;

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

public class list extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView  mListView;

    private static final String[] food = { "猪肉", "猪肝", "猪血", "羊肉", "牛肉", "牛肝", "鹅肉", "兔肉", "狗肉",
            "鸭肉", "鸡肉", "驴肉", "鸡蛋", "鲤鱼", "黄鱼", "虾", "虾皮", "螃蟹", "蛤", "鳖肉",
            "田螺", "大蒜", "葱", "萝卜", "芹菜", "韭菜", "菠菜", "莴笋", "竹笋", "西红柿", "洋葱",
            "醋", "茶", "豆浆", "红糖", "蜂蜜", "牛奶", "白酒", "啤酒" };
    private static final String[] food1 = { "黄莲", "荞麦 雀肉 豆芽", "何首乌 地黄 黄豆 海带", "醋 红豆 半夏 南瓜",
            "橄榄 板粟 韭菜 ", "鲇鱼 鳗鱼 柿子", "狗肉 鲤鱼 柑橘", "鲤鱼 绿豆", "鳖", "鲤鱼", "金针菇",
            "豆浆 兔肉", "甘草 麦冬", "荞麦面 ", "富含维生素C的食物", "红枣 黄豆",
            "梨 柿子 茄子 花生仁 石榴 香瓜 芹菜 蜂蜜 西红柿", "芹菜 ", "鸭肉", "香瓜 木耳 牛肉 蚕豆 玉米",
            "地黄 何首乌 白术", "枣", "橘子 木耳", "黄瓜 蚬、蛤、蟹", "牛肉", "豆腐 鳝鱼 黄瓜", "蜂蜜",
            "糖浆", "白酒", "蜂蜜", "胡萝卜", "酒", "蜂蜜", "竹笋", "皮蛋", "豆腐 韭菜",
            "钙片果汁  药物 韭菜 柠檬", "胡萝卜 核桃 啤酒 红薯", "海鲜" };
    private static final int[] resId = { R.drawable.pork, R.drawable.pigliver, R.drawable.pigblood,
            R.drawable.lamb, R.drawable.beef, R.drawable.beefliver,
            R.drawable.goose, R.drawable.rabbit, R.drawable.dog,
            R.drawable.duck, R.drawable.chicken, R.drawable.donkey,
            R.drawable.egg, R.drawable.carp, R.drawable.yellowfish,
            R.drawable.shrimp, R.drawable.shrimp2, R.drawable.crab,
            R.drawable.clam, R.drawable.turtle, R.drawable.riversnail,
            R.drawable.garlic, R.drawable.onion, R.drawable.radish,
            R.drawable.celery, R.drawable.leek, R.drawable.spinach,
            R.drawable.lettuce, R.drawable.bamboo, R.drawable.tomato,
            R.drawable.foreignonion, R.drawable.vinegar, R.drawable.tea,
            R.drawable.beanmilk, R.drawable.brownsuger, R.drawable.honey,
            R.drawable.milk, R.drawable.whitespirit, R.drawable.beer };
    private static final String [] foodjianjie={"猪肉是目前人们餐桌上最常见的肉类食物之一，猪瘦肉中富含铁，容易被人体吸收，能预防贫血。猪肉味甘咸，性平，有补虚、滋阴、养血、润燥的功效。"
            ,"猪肝味甘、苦，性温，归肝经。猪肝富含多种营养素，是预防缺血性贫血的首选食品，猪肝中的铁容易被人体吸收，是理想的补肝、明目、养血的食品。"
            ,"猪血味甘、苦，性温，有解毒清肠、补血美容的功效。猪血富含维生素B2、维生素C、蛋白质、铁、磷、钙、尼克酸等营养成分。",
            "羊肉味甘、性温，具有补虚劳，祛寒冷，温补气血；益肾气，补形衰，开胃健力的功效。用于气血不足、腹部冷痛、体虚怕冷、腰膝酸痛、面黄肌瘦、血气两亏等一切虚状均有补益效果，最适宜冬季食用。",
            "牛肉有补中益气，滋养脾胃，强健筋骨，化痰息风，止渴止涎之功效。牛肉富含蛋白质，而脂肪少，氨基酸组成比猪肉更接近人体需要，能提高机体抗病能力。",
            "养血，补肝，明目。牛肝中铁质丰富，是补血食品中最常用的食物。"
            ,"鹅肉含有人体生长发育所必需的各种氨基酸，其组成接近人体所需氨基酸的比例，从生物学价值上来看，鹅肉是是理想的高蛋白、低脂肪、低胆固醇的营养健康食品，其亚麻酸含量超过其它肉类。鹅肉性平、味甘，具有益气补虚，和胃止渴的功效。",
            "兔肉质地细嫩，味道鲜美，营养丰富，与猪牛、羊肉相比较，兔肉营养成分独特，具有高铁、高钙、高磷脂和低脂肪、低胆固醇等特点，并且具有很高的消化率(可达85%)，食后极易被消化吸收。",
            "狗肉温补脾胃、补肾助阳、壮力气、补血脉。狗肉不仅蛋白质含量高，而且蛋白质质量极佳，尤以球蛋白比例大，对增强机体抗病力和细胞活力及器官功能有明显作用。",
            "富含蛋白质、脂肪、铁、钾、糖等多种营养成分。其饱和脂肪酸的含量比猪肉、牛肉、羊肉少得多，脂肪酸熔点低，易于消化。所含胆固醇比鱼还要低一些。《本草纲目》记载：鸭肉主大补虚劳，最消毒热，利小便，除水肿，消胀满，利脏腑，退疮肿，定惊痫。",
            "鸡肉含丰富蛋白质，种类多，其含量比猪、牛、羊肉都高，而脂肪含量比其它肉类低，且多为不饱和脂肪酸，营养价值高，消化率高，很容易被人体吸收利用，有增强体力、强壮身体的作用。",
            "驴肉富含蛋白质，而且含有动物胶、骨胶原、钙、硫等成分，其中含有的高级不饱和脂肪酸，尤其是亚油酸、亚麻酸，对动脉硬化、冠心病、高血压有着良好的保健作用。中医认为：驴肉性味甘凉，有补气养血、滋阴壮阳、安神去烦功效。",
            "鸡蛋被认为是营养丰富的食品，含有蛋白质、脂肪、卵黄素、卵磷脂、维生素和铁、钙、钾等人体所需要的矿物质。鸡蛋味甘、性平，具有养心安神、补血、滋阴润燥的功效。",
            "鲤鱼的蛋白质不但含量高，而且质量也佳，人体消化吸收率可达96%，并能供给人体必需的氨基酸、矿物质、维生素A和维生素D。鲤鱼味甘、性平，具有健脾开胃、消水肿、利小便的作用。",
            "黄鱼含有丰富的蛋白质、微量元素和维生素，对人体有很好的补益作用。中医认为，黄鱼有和胃止血、益肾补虚、健脾开胃、安神止痢、益气填精之功效，对贫血、失眠、头晕、食欲不振及妇女产后体虚有良好疗效。",
            "虾营养极为丰富，含蛋白质是鱼、蛋、奶的几倍到几十倍；还含有丰富的钾、碘、镁、磷等矿物质及维生素A、氨茶碱等成分。",
            "虾皮中含有丰富的蛋白质和矿物质，尤其是钙的含量极为丰富,是缺钙者补钙的较佳途径之一。",
            "螃蟹含有丰富的蛋白质及钙、磷、铁等微量元素，对身体有很好的滋补作用。中医学认为螃蟹性寒、味咸，有清热、散血结、续断伤、理经脉和滋阴等功用；其壳可清热解毒、破淤清积止痛。",
            "肉味鲜美、营养丰富，蛋白质含量高，氨基酸的种类组成及配比合理； 脂肪含量低，不饱和脂肪酸较高，易被人体消化吸收。蛤味咸、性寒，有滋阴、利水、化痰、软坚的功效。",
            "鳖肉偏于滋阴补肾、补虚。是久病体弱，消瘦无力等人群的食疗佳品。鳖味咸、性平，具有滋阴凉血、平肝益气、散结软坚、消淤等功效。",
            "含蛋白质、脂肪、碳水化合物、钙、磷、铁、硫胺素、核黄素、尼克酸、维生素。田螺味咸、性寒，有清热利水、除湿解读的功效。",
            "大蒜含有丰富的营养成分，尤其是具有独特生物活性的蒜素等含硫化合物及硒蛋白等功能成分，这些物质具有显著的医用和食用价值。中医理论认为，大蒜生者辛热、熟者甘温，可除寒湿、怯阴邪、下气暖中、消谷化积、破恶血、攻冷积。",
            "葱的主要营养成分是蛋白质、糖类、维生素A原(主要在绿色葱叶中含有)、食物纤维以及磷、铁、镁等矿物质等。中医记载：葱能发汗解表，散寒通阳，解毒散凝。主治风寒感冒轻症，痈肿疮毒，痢疾脉微，寒凝腹痛，小便不利等病症。",
            "萝卜含有丰富的碳水化合物、纤维素、维生素C及钙、磷、钾、铁等矿物质，营养丰富；萝卜还有促进新陈代谢，增进食欲的作用，对于治疗消化不良、胃脘胀满、咳嗽多痰、胸闷气喘、伤风感冒有一定的疗效。",
            "芹菜含有蛋白质、脂肪、碳水化合物、纤维素、维生素、矿物质等营养成分。其中，维生素B、P的含量较多。矿物质元素钙、磷、铁的含量更是高于一般绿色蔬菜。",
            "韭菜性温，味辛，具有补肾起阳作用，且含有大量维生素和粗纤维，能增进胃肠蠕动，治疗便秘。",
            "菠菜含水量高（90%～93%），而热量低，是镁、铁、钾和维生素A的优质来源；也是钙和维生素C的上等来源。所含的磷、锌、叶酸和维生素B6也较为丰富。菠菜中含有的维生素C能够提高铁的吸收率，并促进铁与造血的叶酸共同作用，有效地预防贫血症。",
            "莴苣含蛋白质、脂粉、碳水化合物、钙、磷、铁、胡萝卜素、及维生素B、维生素C、尤其含烟酸较多。莴苣味道清新且略带苦味，可刺激消化酶分泌，增进食欲。其乳状浆液，可增强胃液、消化腺的分泌和胆汁的分泌，从而促进消化。",
            "具有滋阴凉血、和中润肠、清热化痰、解渴除烦、清热益气、利隔爽胃、利尿通便、解毒透疹、养肝明目、消食的功效，还可开胃健脾，宽肠利膈，通肠排便，开膈豁痰，消油腻，解酒毒。",
            "番茄富含维生素C，其含有的番茄红素有利尿和抑制细菌生长的作用，是优良的抗氧化剂，多吃番茄具有抗衰老作用，使皮肤保持白皙。西红柿味酸微甘、性平，具有生津止渴，健胃消食，凉血平肝，清热解毒，降低血压之功效。",
            "洋葱所含的微量元素硒是一种很强的抗氧化剂，能清除体内的自由基，增强细胞的活力和代谢能力，具有抗衰老的功效。",
            "醋可以开胃，促进唾液和胃液的分泌，帮助消化吸收，使食欲旺盛，消食化积。醋还有很好的抑菌和杀菌作用，能有效预防肠道疾病、流行性感冒和呼吸疾病。",
            "茶叶内含化合物500种左右，有些是人体必需的营养成分。如维生素类、蛋白质、氨基酸、类脂类、糖类及矿物质元素等，对人体有较高营养价值。有些是对人体有保健和药用价值的成分，如茶多酚、咖啡碱、脂多糖等，常喝茶有利于人体健康。",
            "豆浆含有丰富的植物蛋白，磷脂，维生素B1、B2，烟酸和铁、钙等矿物质，尤其是钙的含量，虽不及豆腐高，但比其他任何乳类都丰富。豆浆是防治高血脂、高血压、动脉硬化等疾病的理想食品。",
            "红糖中所含有的葡萄糖、果糖等多种单糖和多糖类能量物质，为人体提供能量。",
            "蜂蜜含有70%以上的转化糖，能够被人体肠壁细胞直接吸收利用，没有必要经人体消化，经常服用蜂蜜，能帮助消化。",
            "牛奶的营养成分很高，牛奶中的矿物质种类也非常丰富，除了我们所熟知的钙以外，磷、铁、锌、铜、锰、钼的含量都很多。牛奶是人体钙的最佳来源，而且钙磷比例非常适当，利于钙的吸收。牛奶中含组成人体蛋白质的氨基酸有20种，其中有8种是人体本身不能合成的，为必需氨基酸，牛奶是人类最理想的天然食品。",
            "白酒主要由水乙醇和少量微量元素组成。夜晚服用少量的白酒，可平缓的促进血液循环，起到催眠作用。饮少量白酒可刺激胃液分泌与唾液分泌，因而起到健胃和止疼痛、利小便及驱虫的作用。白酒味苦、甘、辛，性温，有毒，入心、肝、肺、胃经。",
            "啤酒营养丰富，其中含有丰富的氨基酸，是原料大麦含有的蛋白质经过酶的作用分解而产生的。且啤酒中还含有多种维生素。适量饮啤酒有强心、利尿、健胃的功效。"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initListView();
        //this.setListAdapter(listItemAdapter);
        //getListView().setOnItemClickListener(this);
        setContentView(R.layout.activity_list);
        mListView=(ListView)findViewById(R.id.lv);
        mListView.setAdapter(new MyBaseAdapter());
        mListView.setOnItemClickListener(this);
    }

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return food.length;
        }

        @Override
        public Object getItem(int position) {
            return food [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(list.this,R.layout.collocation_list,null);//在list_item中有两个id,现在要把他们拿过来
            TextView title=(TextView) view.findViewById(R.id.itemTitle);
            TextView detail=(TextView) view.findViewById(R.id.itemDetail);
            ImageView imageView=(ImageView)view.findViewById(R.id.photo);
            //组件一拿到，开始组装
            title.setText(food[position]);
            detail.setText(food1[position]);
            imageView.setBackgroundResource(resId[position]);
            //组装玩开始返回
            return view;
        }
    }



    public void back(View btn){
        Intent main = new Intent(this,MainActivity.class);
        startActivity(main);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent intent=new Intent();
        intent.setClass(this, FoodInfo.class);
        intent.putExtra("drawable", resId[position]);
        intent.putExtra("foodname", food[position]);
        intent.putExtra("efoodnema", food1[position]);
        intent.putExtra("foodinfo", foodjianjie[position]);
        startActivity(intent);
    }
}
