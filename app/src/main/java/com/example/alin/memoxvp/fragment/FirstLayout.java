package com.example.alin.memoxvp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alin.memoxvp.R;

/**
 * Created by vasin on 2/10/2016.
 */
public class FirstLayout extends Fragment{
    Typeface boldTypeface;
    Typeface thinTypeface;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.walkthrough_layout_1,container,false);

        ((TextView) view.findViewById(R.id.title)).setTypeface(boldTypeface);
        ((TextView) view.findViewById(R.id.desc)).setTypeface(thinTypeface);

        return view;
    }

    public void setTypeface(Typeface boldTypeface, Typeface thinTypeface) {
        this.boldTypeface = boldTypeface;
        this.thinTypeface = thinTypeface;
    }
}
