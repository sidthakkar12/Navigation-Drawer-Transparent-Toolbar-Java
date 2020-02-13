package com.app.navigationdrawersample.customviews;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import com.app.navigationdrawersample.utils.AppController;
import com.app.navigationdrawersample.utils.RxBus;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class BaseActivity extends AppCompatActivity {

    public RxBus rxBus = AppController.getInstance().getmRxBus();

    public void replaceFragment(String targetClassName, int container, Object bundle, boolean isClearStack) {
        if (isClearStack) {
            clearBackStack();
        }

        String fragmentTag = getFragmentFromClassName(targetClassName).getClass().getSimpleName();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(fragmentTag)
//                .setCustomAnimations(R.anim.anim_slide_in_left, 0, 0, R.anim.anim_slide_out_left)
                .replace(container, getFragmentFromClassName(targetClassName), fragmentTag)
                .commitAllowingStateLoss();
    }

    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), POP_BACK_STACK_INCLUSIVE);
        }
    }

    private Fragment getFragmentFromClassName(String strFragmentPath) {
        Fragment classByName = null;
        try {
            classByName = (Fragment) Class.forName(strFragmentPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classByName;
    }
}
