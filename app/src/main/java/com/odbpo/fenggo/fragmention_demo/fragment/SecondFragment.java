package com.odbpo.fenggo.fragmention_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
public class SecondFragment extends MySupportFragment {

    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.btn_back)
    Button btnBack;

    private static Bundle bundle;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    public static SecondFragment newInstance(Bundle bundle) {
        SecondFragment.bundle = bundle;
        return new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_second, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        String value = bundle.getString("key");
        Toast.makeText(_mActivity, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_next, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                start(ThirdFragment.newInstance());
                break;
            case R.id.btn_back:
                Bundle bundle = new Bundle();
                bundle.putString("key_back","back_data");
                setFragmentResult(1000,bundle);
                pop();//类似activity的finish
                break;
        }
    }

}
