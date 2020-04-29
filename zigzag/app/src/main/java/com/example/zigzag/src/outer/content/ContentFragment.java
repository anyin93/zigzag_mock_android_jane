package com.example.zigzag.src.outer.content;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zigzag.R;
import com.example.zigzag.src.main.MainActivity;
import com.example.zigzag.src.main.store.ContentsPagerAdapter;
import com.example.zigzag.src.outer.OuterActivity;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {


    private int mCategoryNum;

    public ContentFragment() {
    }


    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public ContentFragment(int categoryNum) {
        this.mCategoryNum=categoryNum;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_content, container, false);

        return view;
    }


}
