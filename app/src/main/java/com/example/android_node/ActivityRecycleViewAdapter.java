package com.example.android_node;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_node.models.Activity;

import java.util.List;

public class ActivityRecycleViewAdapter  extends RecyclerView.Adapter<ActivityRecycleViewAdapter.ViewHolder> {
    private List<Activity> mActivities;

    public ActivityRecycleViewAdapter(List<Activity> activities) {
        this.mActivities = activities;
    }

    @NonNull
    @Override
    public ActivityRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        // create a new view
        View activityListItem = inflator.inflate(R.layout.activities, parent, false);
        ActivityRecycleViewAdapter.ViewHolder viewHolder = new ViewHolder(activityListItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityRecycleViewAdapter.ViewHolder holder, int position) {
        // holder is the (already created) activity_list_item (= ViewHolder-object)
        // - gets element from your dataset at this position
        // - replaces the contents of the view with that element
        final Activity activity = mActivities.get(position);

        holder.admin.setText(activity.getAdmin());
        holder.name.setText(activity.getName());
        holder.description.setText(activity.getDescription());
        holder.startDate.setText((CharSequence) activity.getStartDate());
        holder.endDate.setText((CharSequence) activity.getEndDate());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        // ViewHolder is the view of a activity_list_view
        // one drink_list_item contains 3 views
        // Provide a reference to each view in the activity_list_item

        public TextView admin;
        public TextView name;
        public TextView description;
        public TextView startDate;
        public TextView endDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            admin = (TextView) itemView.findViewById(R.id.activity_item_admin);
            name = (TextView) itemView.findViewById(R.id.activity_item_name);
            description = (TextView) itemView.findViewById(R.id.activity_item_description);
            startDate = (TextView) itemView.findViewById(R.id.activity_item_startDate);
            endDate = (TextView) itemView.findViewById(R.id.activity_item_endDate);
        }
    }
}
