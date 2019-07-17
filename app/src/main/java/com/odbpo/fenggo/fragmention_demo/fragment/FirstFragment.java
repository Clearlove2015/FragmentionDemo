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
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;

/**
 * @author: zc
 * @Time: 2019/7/17 15:00
 * @Desc:
 */
public class FirstFragment extends MySupportFragment {

    @Bind(R.id.btn_next)
    Button btnNext;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_first, container, false);
        ButterKnife.bind(this, view);
        initFragmentAnim();
        return view;
    }

    //设置Fragment切换动画
    private void initFragmentAnim() {
        ((ISupportActivity) _mActivity).setFragmentAnimator(new DefaultNoAnimator());//无动画模式
        //((ISupportActivity) _mActivity).setFragmentAnimator(new DefaultHorizontalAnimator());//水平动画
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        //start(SecondFragment.newInstance());
        Bundle bundle = new Bundle();
        bundle.putString("key","value");
        startForResult(SecondFragment.newInstance(bundle),1000);
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == 1000){
            Toast.makeText(_mActivity,data.getString("key_back"),Toast.LENGTH_SHORT).show();
        }
    }

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "再按一次退出", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
