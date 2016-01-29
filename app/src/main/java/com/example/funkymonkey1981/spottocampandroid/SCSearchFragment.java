package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by funkymonkey1981 on 21/01/16.
 */
public class SCSearchFragment extends Fragment {
    public static EditText searchText;
    SCSearchListener searchCommander;
    private String url = "http://spottodev.spottocamp.com/api/spots?lng=4.8833426&lat=52.389523&tents=1&nudists=1&distance=-1&page=2";

    @Override
    public void onActivityCreated(Bundle saveBundleState){
        super.onActivityCreated(saveBundleState);
        if(getActivity() instanceof SCSearchListener){
            searchCommander = (SCSearchListener)getActivity();
        }else{
            throw new ClassCastException(getActivity().toString());
        }
        searchText = (EditText) getActivity().findViewById(R.id.searchText);
        searchText.setText(url);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container, false);

        final Button searchButton = (Button) view.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(searchText.getWindowToken(), 0);
                        buttonClicked(v);
                    }
                }
        );
        return view;
    }

    public void buttonClicked(View view){
        searchCommander.searchActivate(searchText.getText().toString());
    }
}
