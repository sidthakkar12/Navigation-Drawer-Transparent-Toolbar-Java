package com.app.navigationdrawersample.activities;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.navigationdrawersample.R;
import com.app.navigationdrawersample.adapters.DrawerAdapter;
import com.app.navigationdrawersample.custommodels.HeaderTitleModel;
import com.app.navigationdrawersample.customviews.BaseActivity;
import com.app.navigationdrawersample.fragments.OneFragment;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private ArrayList<String> mListMenuItems = new ArrayList<>();

    private Boolean mDoubleBackToExitPressedOnce = false;

    private CompositeDisposable mDisposables = new CompositeDisposable();

    private Boolean replaceHamburger = false;
    private Boolean shouldShowBack = false;

    private ImageView imgMenu;

    private DrawerLayout drawerLayout;

    private RelativeLayout relativeContainer;

    private RecyclerView recyclerDrawerMenu;

    private AppCompatTextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        receiveRxBus();
        findViews();
        setClickListeners();
        replaceFragment(OneFragment.class.getName(), R.id.containerMain, true, false);
        setDrawerLayout();
        setDrawerRecycler();
    }

    private void receiveRxBus() {
        mDisposables.add(rxBus
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) {
                        if (object != null && object instanceof HeaderTitleModel) {
                            txtTitle.setText(((HeaderTitleModel) object).getHeaderTitle());
                        }
                    }
                }));
    }

    private void findViews() {
        imgMenu = findViewById(R.id.imgMenu);
        drawerLayout = findViewById(R.id.drawerLayout);
        relativeContainer = findViewById(R.id.relativeContainer);
        recyclerDrawerMenu = findViewById(R.id.recyclerDrawerMenu);
        txtTitle = findViewById(R.id.txtTitle);
    }

    private void setClickListeners() {
        imgMenu.setOnClickListener(this);
    }

    private void setDrawerLayout() {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                float slideX = drawerView.getWidth() * slideOffset;
                relativeContainer.setTranslationX(slideX);
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    private void setDrawerRecycler() {
        mListMenuItems.add("Fragment 1");
        mListMenuItems.add("Fragment 2");
        mListMenuItems.add("Fragment 3");
        mListMenuItems.add("Fragment 4");

        recyclerDrawerMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerDrawerMenu.setAdapter(new DrawerAdapter(mListMenuItems, this));
    }

    public void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (replaceHamburger) {
            getSupportFragmentManager().popBackStackImmediate();

        } else {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgMenu:
                if (!replaceHamburger) {
                    if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }

                } else {
                    getSupportFragmentManager().popBackStack();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDisposables.clear();
        mDisposables.dispose();
    }
}
