package com.example.dell_pc.myapplication.framgment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell_pc.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HostFragment extends Fragment {


    public HostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_host, container, false);
        return inflate;
    }

}
