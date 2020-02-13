package com.app.navigationdrawersample.customviews;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.app.navigationdrawersample.utils.AppController;
import com.app.navigationdrawersample.utils.RxBus;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class BaseFragment extends Fragment {

    public RxBus rxBus = AppController.getInstance().getmRxBus();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
