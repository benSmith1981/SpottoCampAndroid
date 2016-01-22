package com.example.funkymonkey1981.spottocampandroid;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class SCListView extends ArrayAdapter<SCJSON.Spots.Data> {

    private LayoutInflater inflater;
    private ImageLoader mImageLoader;
    Context context;

    public SCListView(Context context, @LayoutRes int layoutId, ArrayList<SCJSON.Spots.Data> campsites) {
        super(context, layoutId, campsites);
        inflater = LayoutInflater.from(context);
        mImageLoader = com.example.funkymonkey1981.spottocampandroid.SCImageLoader.getInstance().getImageLoader();
        this.context = context;

    }
    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView;
        if (view == null) {
            rowView = inflater.inflate(R.layout.list_item, null, true);
        } else {
            rowView = view;
        }
        final SCJSON.Spots.Data data = getItem(position);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(data.getName());

        ImageView imageView = (ImageView)rowView.findViewById(R.id.img);
        Picasso.with(rowView.getContext()).load(data.getThumbnail()).into(imageView);

        return rowView;
    }



}
