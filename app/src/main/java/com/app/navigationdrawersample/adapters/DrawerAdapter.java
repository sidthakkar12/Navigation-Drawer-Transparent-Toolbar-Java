package com.app.navigationdrawersample.adapters;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.navigationdrawersample.activities.MainActivity;
import com.app.navigationdrawersample.R;
import com.app.navigationdrawersample.fragments.FourFragment;
import com.app.navigationdrawersample.fragments.OneFragment;
import com.app.navigationdrawersample.fragments.ThreeFragment;
import com.app.navigationdrawersample.fragments.TwoFragment;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private static String TAG = DrawerAdapter.class.getSimpleName();

    private ArrayList<String> mListMenuItems = new ArrayList<>();

    private MainActivity mainActivity;

    public DrawerAdapter(ArrayList<String> mListMenuItems, MainActivity mainActivity) {
        this.mListMenuItems = mListMenuItems;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = (LayoutInflater.from(mainActivity).inflate(R.layout.raw_menu, viewGroup, false));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        viewHolder.txtMenuItem.setText(mListMenuItems.get(position));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openFragment(viewHolder.getAdapterPosition());
                        notifyDataSetChanged(); // use this for selector
                    }
                }, 300);
            }
        });
    }

    private void openFragment(Integer position) {
        switch (position) {
            case 0:
                mainActivity.replaceFragment(OneFragment.class.getName(), R.id.containerMain, true, false);
                break;
            case 1:
                mainActivity.replaceFragment(TwoFragment.class.getName(), R.id.containerMain, true, false);
                break;
            case 2:
                mainActivity.replaceFragment(ThreeFragment.class.getName(), R.id.containerMain, true, false);
                break;
            case 3:
                mainActivity.replaceFragment(FourFragment.class.getName(), R.id.containerMain, true, false);
                break;
        }
        mainActivity.closeDrawer();
    }

    @Override
    public int getItemCount() {
        return mListMenuItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView txtMenuItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMenuItem = itemView.findViewById(R.id.txtMenuItem);
        }
    }
}

