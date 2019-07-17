package com.odbpo.fenggo.fragmention_demo;

import android.os.Bundle;

import com.odbpo.fenggo.fragmention_demo.base.MySupportActivity;
import com.odbpo.fenggo.fragmention_demo.base.MySupportFragment;
import com.odbpo.fenggo.fragmention_demo.fragment.FirstFragment;

public class MainActivity extends MySupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySupportFragment fragment = findFragment(FirstFragment.class);
        if (fragment == null) {
            //操作子Fragment
            loadRootFragment(R.id.fl_container, FirstFragment.newInstance());
        }
    }

}
