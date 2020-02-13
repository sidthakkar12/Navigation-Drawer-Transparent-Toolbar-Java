package com.app.navigationdrawersample.utils;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.ColorInt;
import android.view.View;

public class CommonUtils {
    public static void setLightStatusBar(Activity activity, boolean isLightStatusBar) {
        //

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightStatusBar) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    public static void setNavigationBarColor(Activity activity, int color) {
            activity.getWindow().setNavigationBarColor(color);
    }

    public static void fullScreenCall(Activity activity, boolean isShow) {
        if(Build.VERSION.SDK_INT < 19){
            View v = activity.getWindow().getDecorView();
            if (isShow) {
                v.setSystemUiVisibility(View.VISIBLE);
            } else {
                v.setSystemUiVisibility(View.GONE);
            }
        } else {
            //for higher api versions.
            View decorView = activity.getWindow().getDecorView();
            if (isShow) {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(uiOptions);
            } else {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                decorView.setSystemUiVisibility(uiOptions);
            }
        }
    }

    // This snippet hides the system bars.
    public static void hideSystemUI(Activity activity) {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    // This snippet shows the system bars. It does this by removing all the flags
    // except for the ones that make the content appear under the system bars.
    public static void showSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
