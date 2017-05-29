package com.example.kensukeizumi.horizontalrecyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.action;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<List<String>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("++++PARENT_TOUCH", "INTERCEPT_PARENT_TOUCH");
                if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("++++PARENT_TOUCH", "INTERCEPT_PARENT_TOUCH_MOVE");
                }

                if (e.getAction() == MotionEvent.ACTION_SCROLL) {
                    Log.d("++++PARENT_TOUCH", "INTERCEPT_PARENT_TOUCH_SCROLL");
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("++++PARENT_TOUCH", "PARENT_TOUCH");
                if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("++++PARENT_TOUCH", "PARENT_TOUCH_MOVE");
                }

                if (e.getAction() == MotionEvent.ACTION_SCROLL) {
                    Log.d("++++PARENT_TOUCH", "INTERCEPT_PARENT_TOUCH_SCROLL");
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mList = new ArrayList<List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("AAA");
        list1.add("BBB");
        list1.add("CCC");
        list1.add("DDD");

        List<String> list2 = new ArrayList<String>();
        list2.add("EEE");
        list2.add("FFF");
        list2.add("GGG");
        list2.add("HHH");

        List<String> list3 = new ArrayList<String>();
        list3.add("III");
        list3.add("JJJ");
        list3.add("KKK");
        list3.add("LLL");

        List<String> list4 = new ArrayList<String>();
        list4.add("MMM");
        list4.add("NNN");
        list4.add("OOO");
        list4.add("PPP");

        mList.add(list1);
        mList.add(list2);
        mList.add(list3);
        mList.add(list4);

        mAdapter = new HorizontalListAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
