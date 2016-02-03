package com.example.funkymonkey1981.spottocampandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 29/01/16.
 */
public class SCRecyclerView extends RecyclerView.Adapter<SCRecyclerView.ViewHolder> {


    protected ArrayList<Data> campsites;
    public ArrayList<Data> getCampsites() {
        return campsites;
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtTitle;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SCRecyclerView(ArrayList<Data> campsites) {
        this.campsites = campsites;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SCRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder holder = (ViewHolder) v.getTag();
                Intent detailIntent = new Intent(SCMainActivity.getInstance(), SCDetail.class);
                int position = holder.getPosition();
                Data data = getCampsites().get(position);

                Bundle mBundle = new Bundle();
                mBundle.putSerializable(Constants.SER_KEY, data);
                detailIntent.putExtras(mBundle);
                v.getContext().startActivity(detailIntent);
            }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // data item based on the position
        final Data data = this.campsites.get(position);
        // - replace the contents of the view with that element
        holder.txtTitle.setText(data.getName());
        Picasso.with(holder.itemView.getContext())
                .load(data.getThumbnail())
                .resize(500, 500)
                .centerCrop()
                .into(holder.imageView);
        holder.txtTitle.setTag(holder);
        holder.imageView.setTag(holder);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return campsites.size();
    }

    private class OnClickListener {
    }
}