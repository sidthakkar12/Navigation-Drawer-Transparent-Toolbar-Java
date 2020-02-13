package com.app.navigationdrawersample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.navigationdrawersample.R;
import com.app.navigationdrawersample.custommodels.HeaderTitleModel;
import com.app.navigationdrawersample.customviews.BaseFragment;
import com.app.navigationdrawersample.utils.CommonUtils;

public class ThreeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        setHeaderTitle();
        CommonUtils.setLightStatusBar(getActivity(), false);
        CommonUtils.setNavigationBarColor(getActivity(), Color.parseColor("#FFFFFF"));
        return view;
    }

    private void setHeaderTitle() {
        HeaderTitleModel headerTitleModel = new HeaderTitleModel();
        headerTitleModel.setHeaderTitle("Fragment Three");
        rxBus.send(headerTitleModel);
    }
}
