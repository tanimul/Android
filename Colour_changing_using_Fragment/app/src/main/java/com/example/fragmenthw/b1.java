package com.example.fragmenthw;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class b1 extends Fragment {


    public b1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container!=null){
            container.removeAllViews();
        }
        if(getArguments()!=null){
            String data=getArguments().getString("data");
            Toast.makeText(getActivity(), ""+data, Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_b1, container, false);
    }

}
