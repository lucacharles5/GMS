package com.example.gerdaumanagement.gerdaumanagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class menuTec extends Fragment {


    public menuTec() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Set title bar
        ((MenuDrawer) getActivity()).setActionBarTitle("Início");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_tec, container, false);

    }


}
