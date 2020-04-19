package com.example.testopen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class News3Fgt extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_news3, container, false);
        return view;
    }





    public static News3Fgt newInstance() {
        News3Fgt f = new News3Fgt();
        return f;
    }
}
