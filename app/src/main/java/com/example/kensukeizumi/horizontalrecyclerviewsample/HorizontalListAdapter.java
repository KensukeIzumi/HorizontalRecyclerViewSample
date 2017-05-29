package com.example.kensukeizumi.horizontalrecyclerviewsample;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kensukeizumi on 2017/05/29.
 */

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.HorizontalViewHolder>{
    private List<List<String>> mList;
    private Context mContext;

    public HorizontalListAdapter(Context context, List<List<String>> list) {
        mList = list;
        mContext = context;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mVerticalRecyclerView;
        private TextView mListTitle;

        public HorizontalViewHolder(View view) {
            super(view);
            mVerticalRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_vertical);
            mListTitle = (TextView) view.findViewById(R.id.list_title);
        }

    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertial_list, null);
        HorizontalViewHolder holder = new HorizontalViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalListAdapter.HorizontalViewHolder holder, int position) {

        holder.mListTitle.setText("This is a " + position + " list");
        List textList = mList.get(position);
        holder.mVerticalRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        holder.mVerticalRecyclerView.setLayoutManager(layoutManager);
        holder.mVerticalRecyclerView.setNestedScrollingEnabled(false);

        VerticalListAdapter verticalListAdapter = new VerticalListAdapter(mContext, textList);

        holder.mVerticalRecyclerView.setAdapter(verticalListAdapter);


        holder.mVerticalRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("++++CHILD_TOUCH", "INTERCEPT_CHILD_TOUCH");
                Log.d("event index", String.valueOf(e.getAction()));

                if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("++++CHILD_TOUCH", "INTERCEPT_CHILD_TOUCH_MOVE");
                }

                if (e.getAction() == MotionEvent.ACTION_SCROLL) {
                    Log.d("++++CHILD_TOUCH", "INTERCEPT_CHILD_TOUCH_SCROLL");
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("++++CHILD_TOUCH", "CHILD_TOUCH");
                if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("++++CHILD_TOUCH", "CHILD_TOUCH_MOVE");
                }

                if (e.getAction() == MotionEvent.ACTION_SCROLL) {
                    Log.d("++++CHILD_TOUCH", "INTERCEPT_CHILD_TOUCH_SCROLL");
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        }

        return mList.size();
    }
}
