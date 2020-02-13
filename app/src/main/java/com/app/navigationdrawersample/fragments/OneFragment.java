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

public class OneFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        setHeaderTitle();
        CommonUtils.setLightStatusBar(getActivity(), true);
        CommonUtils.setNavigationBarColor(getActivity(), Color.parseColor("#000000"));
        view.findViewById(R.id.btnHide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.hideSystemUI(getActivity());
            }
        });
        view.findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.showSystemUI(getActivity());
            }
        });
        return view;
    }

    private void setHeaderTitle() {
        HeaderTitleModel headerTitleModel = new HeaderTitleModel();
        headerTitleModel.setHeaderTitle("Fragment One");
        rxBus.send(headerTitleModel);
    }
}
