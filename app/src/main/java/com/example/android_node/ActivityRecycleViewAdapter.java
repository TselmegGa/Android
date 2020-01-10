package com.example.android_node;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_node.models.Activity;

import java.util.List;

public class ActivityRecycleViewAdapter  extends RecyclerView.Adapter<ActivityRecycleViewAdapter.ViewHolder> {
    private List<Activity> mActivities;

    private final ActivityOnclickHandler mClickHandler;

    public ActivityRecycleViewAdapter(List<Activity> activities, ActivityOnclickHandler mClickHandler) {
        this.mActivities = activities;
        this.mClickHandler = mClickHandler;
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

        holder.name.setText(activity.getName());
        holder.description.setText(activity.getDescription());
        holder.startDate.setText((CharSequence) activity.getStartDate());
        holder.endDate.setText((CharSequence) activity.getEndDate());
        holder.id.setText( "" + activity.getId());


    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mActivities.size();

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // ViewHolder is the view of a activity_list_view
        // one drink_list_item contains 3 views
        // Provide a reference to each view in the activity_list_item
        private TextView name;
        private TextView description;
        private TextView startDate;
        private TextView endDate;

        private TextView id;

        private Button details;
        private Button remove;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.activity_item_name);
            description = (TextView) itemView.findViewById(R.id.activity_item_description);
            startDate = (TextView) itemView.findViewById(R.id.activity_item_startDate);
            endDate = (TextView) itemView.findViewById(R.id.activity_item_endDate);
            id = (TextView) itemView.findViewById(R.id.activity_item_id);

            details = (Button) itemView.findViewById(R.id.btn_readActivity);
            remove = (Button) itemView.findViewById(R.id.btn_deleteActivity);
            remove.setOnClickListener(this);
            details.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickHandler.onActivityClick(v, Integer.parseInt(id.getText().toString()));
        }
    }
}
