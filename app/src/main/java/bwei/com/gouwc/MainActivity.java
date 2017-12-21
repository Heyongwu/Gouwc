package bwei.com.gouwc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import bwei.com.gouwc.eventbus.MessageEvent;
import bwei.com.gouwc.eventbus.PriceAndCountEvent;

public class MainActivity extends AppCompatActivity implements IMainActivity{
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        new Percenter(this).showget();
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }   private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) findViewById(R.id.checkbox2);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvNum = (TextView) findViewById(R.id.tv_num);
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }
    @Override
    public void showBeans(JavaBean javaBean) {
        List<JavaBean.DataBean> list = javaBean.getData();
        ArrayList<List<JavaBean.DataBean.ListBean>> lists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<JavaBean.DataBean.ListBean> datas=list.get(i).getList();
            lists.add(datas);
        }
        adapter = new Adapter(MainActivity.this,list,lists);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        //默认其他全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }

}
