package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class CampingList extends ArrayAdapter<SpottoCampJSON.Spots.Data> {

    private LayoutInflater inflater;

    public CampingList(Context context, @LayoutRes int layoutId, ArrayList<SpottoCampJSON.Spots.Data> campsites) {
        super(context, layoutId, campsites);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView;
        if (view == null) {
            rowView = inflater.inflate(R.layout.list_item, null, true);
        } else {
            rowView = view;
        }
        final SpottoCampJSON.Spots.Data data = getItem(position);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(data.getName());
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
//        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
