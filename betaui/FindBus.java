package com.example.betaui;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.*;
import java.util.ArrayList;

public class FindBus extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private ListView mListView1, mListView2;

    public ArrayList<String> routes;
    public ArrayList<String> stops;
    TextView textView = (TextView) findViewById(R.id.locationPanel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_bus);

        mListView1 = (ListView)findViewById(R.id.listView1);
        mListView2 = (ListView)findViewById(R.id.listView2);

        mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, routes));
        mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stops));

        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);
    }
    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = MeasureSpec.makeMeasureSpec(mListView.getWidth(), MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }

    public void onCheckedChanged(CompoundButton aSwitch, boolean bool){
        if(aSwitch.isChecked()){
            textView.setEnabled(true);
        } else {
            textView.setEnabled(false);
        }
    }

    public void finish(View v){
        finish();
    }

    public void ping(View v){
        Locator locationProvider = new Locator();
        locationProvider.requestPermission();


    }
}