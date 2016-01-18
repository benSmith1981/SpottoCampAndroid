package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.StringTokenizer;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class CampingList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final Integer[] imageId;

    public CampingList(Activity context, String[] title, Integer[] imageId)
    {
        super(context, R.layout.list_item, title);
        this.context = context;
        this.title = title;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(title[position]);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
