package com.example.kensukeizumi.horizontalrecyclerviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kensukeizumi on 2017/05/29.
 */

public class VerticalListAdapter extends RecyclerView.Adapter<VerticalListAdapter.VerticalListAdapterViewHolder> {
    private List<String> mTextList;
    private Context mContext;

    public VerticalListAdapter(Context context, List<String> list) {
        mTextList = list;
        mContext = context;
    }

    public class VerticalListAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public VerticalListAdapterViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.list_item_text);
        }
    }

    @Override
    public VerticalListAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);

        return new VerticalListAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VerticalListAdapterViewHolder holder, int position) {
        holder.mTextView.setText(mTextList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mTextList == null) {
            return 0;
        }

        return mTextList.size();
    }
}
