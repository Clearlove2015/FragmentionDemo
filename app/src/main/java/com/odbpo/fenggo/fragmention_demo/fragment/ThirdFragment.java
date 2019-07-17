package com.odbpo.fenggo.fragmention_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.odbpo.fenggo.fragmention_demo.R;
import com.odbpo.fenggo.fragmention_demo.base.MySupportFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: zc
 * @Time: 2019/7/17 15:00
 * @Desc:
 */
public class ThirdFragment extends MySupportFragment {

    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.btn_go_first)
    Button btnGoFirst;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_third, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_next, R.id.btn_go_first})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                start(FourFragment.newInstance());
                break;
            case R.id.btn_go_first:
                start(FirstFragment.newInstance(),SINGLETASK);
                break;
        }
    }
}
