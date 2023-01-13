package com.mobilelearning.solutions.school_app.ui.dashboard;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mobilelearning.solutions.Fragment_Campus;
import com.mobilelearning.solutions.classroom.Fragment_Classroom;
import com.mobilelearning.solutions.notifications.Fragment_Messages;
import com.mobilelearning.solutions.notifications.Fragment_Notifications;
import com.mobilelearning.solutions.school_app.R;
import com.mobilelearning.solutions.school_app.ViewModel.VMDashboard;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Dashboard extends Fragment {

    private VMDashboard mViewModel;

    private ViewPager2 viewPager;
    private BottomNavigationView botNav;

    public static Fragment_Dashboard newInstance() {
        return new Fragment_Dashboard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMDashboard.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        botNav = view.findViewById(R.id.bottomNavigationView);

        viewPager.setAdapter(new FragmentAdapter(requireActivity()));

        botNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int lnItemID = item.getItemId();

                switch (lnItemID){
                    case R.id.nav_campus:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_classroom:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_messages:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_notifications:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.nav_profile:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
        return view;
    }

    private static class FragmentAdapter extends FragmentStateAdapter{

        private List<Fragment> loList = new ArrayList<>();

        public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            loList.add(new Fragment_Campus());
            loList.add(new Fragment_Classroom());
            loList.add(new Fragment_Messages());
            loList.add(new Fragment_Notifications());
            loList.add(new Fragment_Campus());
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return loList.get(position);
        }

        @Override
        public int getItemCount() {
            return loList.size();
        }
    }
}