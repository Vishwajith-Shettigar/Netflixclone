package com.example.netflixclone.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class Screensliderad extends FragmentStateAdapter {

        private List<Fragment> fragmentList;

        public Screensliderad(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> fragmentList) {
            super(fragmentManager, lifecycle);
            this.fragmentList = fragmentList;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            return fragmentList.get(position);
        }


        @Override
        public int getItemCount() {
            return fragmentList.size();
        }

}
