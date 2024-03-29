package com.example.hp.balanceddiet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class FoodInfo extends AppCompatActivity {
    Button image=null;
    Button back=null;
    TextView name=null;
    TextView foodinfo=null;
    private static final String [] efoodinfo={"猪肉多脂，酸寒滑腻。若中药配方中以黄莲为主时，应忌食猪肉，不然会降低药效，且容易引起腹泻。",
            "《食疗本草》 记载：荞麦难消，动热风，不宜多食。由于荞麦面气味甘平而寒，猪肝多脂，两者都是不易消化之物，所以不宜同食。",
            "同食会消化不良。","猪肝中的铜会加速豆芽中的维生素C氧化，失去其营养价值，因此猪肝不宜与豆芽、西红柿、山楂等富含维生素C的食物同食。",
            "《本草纲目》记载：地黄、何首乌忌一切血、葱、蒜、萝卜，何首乌忌铁器。从药物化学理解之，何首乌所含有机酸中，亦有鞣酸存在。鞣酸遇铁则形成不易溶解之物质，且影响其他有效成分的吸收。而动物学中，皆含铁质，故何首乌亦忌诸血。",
            "《本草纲目》记载：地黄、何首乌忌诸血、葱、蒜、萝卜，服地黄、何首乌诸血忌食之，云能损阳也。",
            "同食容易消化不良。","同食会便秘。","《本草纲目》记载：羊肉同醋食伤人心。羊肉大热，醋性甘温，与酒性相近，两物同煮，易生火动血。",
            "红豆不宜与羊肉同食。","会影响营养成分吸收。","《本草纲目》记载：南瓜不可与羊肉同食，令人气壅。南瓜补中益气，羊肉大热补虚，两补同进，会导致胸闷腹胀等症状。",
            "同食会引起身体不适。","同食会引起身体不适。","易引起气血不顺，发热动火。","《本草图经》记载：鲇鱼肉不可合牛肝食，令人患风，噎涎。同食会引起身体不适。",
            "鳗鱼所含的某些生物活性物质，对人体产生一定的不良作用。牛肝营养丰富，所含生物活性物质极为复杂，二者同食更易产生不利于人体的生化反应。",
            "容易引起中毒。","两者同食，温热助火作用更强，不利健康。","两者同食，温热助火作用更强，不利健康。","柑橘味甘酸、性温，兔肉味酸性冷，两者同食会引起胃肠功能絮乱，导致腹泻。",
            "二者的性味及营养功能不同，不宜共食。《金匮要略》记载：鲤鱼不可合犬肉食之。《饮膳正要》记载：鲤鱼不可与犬肉同食。","狗肉属于大热，有小毒，绿豆则属于大寒，能解毒，两种东西混在一起吃，容易引起身体不适。",
            "《饮膳正要》记载：鸭肉不可与鳖肉同食。《本草纲目》记载：鳖肉甘平无毒，鳖甲咸平。鳖性冷，发水病，而鸭肉也属凉性，所以鸭肉不宜与鳖肉同食。","鸡肉甘温，鲤鱼甘平。鸡肉补中助阳，鲤鱼下气利水，性味不反但功能相乘。因此鸡肉不可与鲤鱼一起食用。",
            "同食会引起心痛。","豆浆中含有胰蛋白酶，与鸡蛋清中的卵松蛋白相结合，会造成营养成分的损失，降低二者的营养价值。","《本草纲目》中说：鸡蛋同兔肉食成泄痢，因此两者同食容易引起腹泻。","同食会中毒。",
            "麦冬养阴生津，鲤鱼利水消肿，两者功能不协调，同食损害健康。","食疗本草 记载：荞麦难消，动热风，不宜多食。由于荞麦面气味甘平而寒，黄鱼多脂，两者都是不易消化之物，所以不宜同食。","大量同食会生成有毒化学物，引起中毒。","同食会中毒。",
            "同食会影响消化。","《名医别录》记载：梨性冷利，多食损人，因此梨性寒冷，蟹亦冷利，两者同食，伤肠胃。","《饮膳正要》记载：柿梨不可与蟹同食。柿中含鞣酸，蟹内富含蛋白，二者相遇，凝固为鞣酸蛋白，不易消化且妨碍消化功能。",
            "蟹肉性寒，茄子甘寒滑利，这两者的食物药性同属寒性。一起吃用，肠胃会不舒服，严重的可能导致腹泻，特别是脾胃虚寒的人更应忌食。","花生仁性味甘平，与螃蟹同食食用易导致腹泻。","刺激肠胃，出现腹痛、恶心、呕吐等症状。",
            "易导致腹泻。","同食会引起蛋白质的吸收受阻。","同食会中毒。","易引起腹泻。","同食易引起腹泻。","猪、兔、鸭之肉都属寒性，而鳖也属寒性，所以不宜配食。","田螺大寒，香瓜冷利，并有轻度导泻作用，二者皆属凉性，同食有损肠胃。所以食用田螺后不宜马上吃香瓜，更不宜同食。",
            "寒性的田螺，遇上滑利的木耳，不利于消化，所以二者不宜同食。","不易消化，容易腹胀。","同食会肠绞痛。","同食容易中毒。","同食会影响营养成分的吸收。","同食会引起腹泻。","《本草纲目》、《饮膳正要》记载：有苍白术，忌食菘、葫荽、蒜，即苍术、白术不宜与白菜，大蒜等同食。",
            "辛热助火。","萝卜会产生一种抗甲状腺的物质硫氰酸，如果同时食用大量的橘子、苹果、葡萄等水果，水果中的类黄酮物质在肠道经细菌分解后就会转化为抑制甲状腺作用的硫氰酸，进而诱发甲状腺肿大。","易诱发过敏性皮炎。","黄瓜中含有维生素C分解酶，两者同食，芹菜中的维生素C将会被分解破坏，降低营养价值。",
            "蚬、蛤、蟹等体内皆含维生素B1分解酶，若与芹菜同食，可将其中的维生素B1破坏，降低营养价值。","《本草纲目》记载：牛肉合韭薤食，令人热病。牛肉甘温，补气助火；韭菜、薤、生姜等食物皆大辛大温之品。如将牛肉配以韭菜、薤、生姜等大辛大温的食物烹调食用，容易上火。",
            "菠菜中的草酸与豆腐中的钙形成草酸钙，使钙质无法吸收。","同食易导致腹泻。","黄瓜中含有维生素C分解酶，与菠菜同食，会破坏菠菜中的维生素C。","同食易导致腹泻。","同食会引起中毒。","同食会感觉胸闷、气短。","同食伤眼睛，引起眼睛不适。",
            "胡萝卜素在胡萝卜中含量较高，其中最具有维生素A生物活性的是β-胡萝卜素，但其在人类肠道中的吸收利用率很低，大约仅为维生素A的六分之一，其他胡萝卜素的吸收率更低， 而且遇酸会分解掉，因此胡萝卜不宜与醋一起食用。","喝酒后在酒精的作用下，人体处于酒精中毒的兴奋期，交感神经系统兴奋，心率加快，血压上升。而浓茶中的主要成分茶碱和咖啡因也可以兴奋人的交感神经系统。此时茶酒结合，可以使交感神经系统更加兴奋，对于有高血压、冠心病的人来说，就有可能使病情加重，甚至可能诱发中风或心肌梗塞。",
            "豆浆中的蛋白质与蜂蜜容易产生变性沉淀，不能被人体吸收。","红糖甘温，竹笋甘寒，食物药性稍有抵触。竹笋蛋白中含有18种左右的氨基酸，其中的赖氨酸在与糖共同加热的过程中，易形成赖氨酸糖基，对人体不利。","《本草纲目》记载：皮蛋忌红糖，同食发呕。","豆腐能清热散血，下大肠浊气，蜂蜜甘凉滑利，两物同食，容易导致腹泻。",
            "易导致腹泻。","牛奶中已经含有充足的钙，再与钙同服，不利于钙的吸收。","容易引起消化不良或腹泻。","牛奶中的钙、磷、铁容易和中药中的有机物质发生化学反应,生成难溶并稳定的化合物,使牛奶和药物的有效成分受到破坏。","牛奶与含草酸多的蔬菜混合食用，会影响钙的吸收。","牛奶和酸性水果不能一起吃。牛奶中的蛋白质８０％以上为酪蛋白，如在酸性情况下，酪蛋白易凝集，导致消化不良或腹泻。",
            "胡萝卜含有丰富的胡萝卜素，与酒精一起进入人体，就会在肝脏中产生毒素，从而损害肝脏功能。","易导致血热，严重会鼻出血。","同食会使胃酸分泌减少，导致胃痉挛等症状，对心脑血管危害大。","同食易患结石。","食用海鲜时饮用大量啤酒会产生过多的尿酸从而引发痛风。尿酸过多便会沉积在关节和软组织中，进而引起关节和组织发。",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodinfo);
        Bundle bundle=getIntent().getExtras();
        String efoodname=bundle.getString("efoodnema");
        String []efoodnames=efoodname.split(" ");
        List<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
        for(int i=0;i<efoodnames.length;i++){
            HashMap<String, String> map=new HashMap<String, String>();
            map.put("TextView04", efoodnames[i]);
            map.put("TextView05", efoodinfo[i]);
            data.add(map);
        }
        ListView list = (ListView)findViewById(R.id.lv2);
        SimpleAdapter mSchedule = new SimpleAdapter(
                this, data, R.layout.ex_foodinfo,
                new String[] {"TextView04","TextView05"},
                new int[] {R.id.TextView04,R.id.TextView05});
        list.setAdapter(mSchedule);
        int drawable=bundle.getInt("drawable");
        String foodname=bundle.getString("foodname");
        String foodinfos=bundle.getString("foodinfo");
        image=findViewById(R.id.Button);
        image.setBackgroundResource(drawable);
        name=findViewById(R.id.name);
        name.setText(foodname);
        foodinfo=(TextView)findViewById(R.id.TextView03);
        foodinfo.setText(foodinfos);
        back=(Button)findViewById(R.id.backbutton);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button)v;
                Intent intent=new Intent(FoodInfo.this,list.class);
                startActivity(intent);
            }
        });
    }
}
