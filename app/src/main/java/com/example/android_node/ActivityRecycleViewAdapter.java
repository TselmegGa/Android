package com.example.android_node;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityRecycleViewAdapter  extends RecyclerView.Adapter<ActivityRecycleViewAdapter.ViewHolder> {
    @NonNull
    @Override
    public ActivityRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityRecycleViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // ViewHolder is the view of a activity_list_view
        // one drink_list_item contains 3 views
        // Provide a reference to each view in the activity_list_item

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
