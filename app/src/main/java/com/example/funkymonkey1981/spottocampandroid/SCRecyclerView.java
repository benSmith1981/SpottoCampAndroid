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
    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // each data item is just a string in this case
        private TextView txtTitle;
        private ImageView imageView;
        private Data mcampsite;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtTitle = (TextView)v.findViewById(R.id.txt);
            imageView = (ImageView)v.findViewById(R.id.img);
        }

        @Override
        public void onClick(View v) {
            Intent detailIntent = new Intent(SCMainActivity.getInstance(), SCDetail.class);
            int position = this.getLayoutPosition();

            Bundle mBundle = new Bundle();
            mBundle.putSerializable(Constants.SER_KEY, mcampsite);
            detailIntent.putExtras(mBundle);
            v.getContext().startActivity(detailIntent);
        }

        public void onBindViewHolder(Data campsite){
            mcampsite = campsite;
            // - replace the contents of the view with that element
            this.txtTitle.setText(mcampsite.getName());
            Picasso.with(this.itemView.getContext())
                    .load(mcampsite.getThumbnail())
                    .resize(200, 200)
                    .centerCrop()
                    .into(this.imageView);

            this.txtTitle.setTag(this);
            this.imageView.setTag(this);
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
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // data item based on the position
        final Data data = this.campsites.get(position);
        holder.onBindViewHolder(data);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return campsites.size();
    }

}