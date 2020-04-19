package com.example.testopen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class News2Fgt extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_news2, container, false);
        return view;
    }





    public static News2Fgt newInstance() {
        News2Fgt f = new News2Fgt();
        return f;
    }
}
