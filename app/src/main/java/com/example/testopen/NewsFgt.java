package com.example.testopen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class NewsFgt extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_news, container, false);
        return view;
    }





    public static NewsFgt newInstance() {
        NewsFgt f = new NewsFgt();
        return f;
    }
}
