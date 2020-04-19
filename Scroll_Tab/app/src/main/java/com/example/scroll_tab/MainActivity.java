package com.example.scroll_tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends FragmentActivity {
     private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager = findViewById(R.id.viewpager_id);
        // creating Custom_Adapter object
        Custom_Adapter custom_adapter = new Custom_Adapter(fragmentManager);
        viewPager.setAdapter(custom_adapter);

    }
}

class Custom_Adapter extends FragmentStatePagerAdapter{
    public Custom_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position==0){
            fragment = new fragment1();
        }
        else if (position==1){
            fragment = new fragment2();
        }
        else if (position==2){
            fragment = new fragment3();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Tab1";
        }
        else if (position==1){
            return "Tab2";
        }
        else if (position==2){
            return "Tab3";
        }

        return null;
    }
}
