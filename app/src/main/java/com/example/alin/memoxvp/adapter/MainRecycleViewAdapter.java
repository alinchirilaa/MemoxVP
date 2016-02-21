package com.example.alin.memoxvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.memoxvp.POJOs.RecyclerItem;
import com.example.alin.memoxvp.R;

import java.util.List;

/**
 * Created by vasin on 2/21/2016.
 */
public class MainRecycleViewAdapter extends RecyclerView.Adapter<MainRecycleViewAdapter.MainViewHolder> {
    private List<RecyclerItem> recyclerItemList;

    public MainRecycleViewAdapter(List<RecyclerItem> recyclerItemList) {
        this.recyclerItemList = recyclerItemList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_main, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {


        RecyclerItem recyclerItem = recyclerItemList.get(position);

        holder.imageViewThumbnail.setImageResource(recyclerItem.getThumbnail());
        holder.textView.setText(recyclerItem.getText());


    }

    @Override
    public int getItemCount() {
        return recyclerItemList.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageViewThumbnail;
        protected TextView textView;


        public MainViewHolder(View view) {
            super(view);
            this.imageViewThumbnail = (ImageView) view.findViewById(R.id.thumbnail_main);
            this.textView = (TextView) view.findViewById(R.id.title_main);

        }


    }

    public void clearRecycler() {
        int size = recyclerItemList.size();

        if (size > 0) {
            recyclerItemList.clear();
        }

    }

}
