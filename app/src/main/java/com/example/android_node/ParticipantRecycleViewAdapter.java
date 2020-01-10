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
import com.example.android_node.models.User;

import java.util.List;

public class ParticipantRecycleViewAdapter extends RecyclerView.Adapter<ParticipantRecycleViewAdapter.ViewHolder> {
    private List<User> users;

    private final ParticipantOnclickHandler mClickHandler;

    public ParticipantRecycleViewAdapter(List<User> users, ParticipantOnclickHandler mClickHandler) {
        this.users = users;
        this.mClickHandler = mClickHandler;
    }
    @NonNull
    @Override
    public ParticipantRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        // create a new view
        View userListItem = inflator.inflate(R.layout.participants, parent, false);
        ParticipantRecycleViewAdapter.ViewHolder viewHolder = new ViewHolder(userListItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantRecycleViewAdapter.ViewHolder holder, int position) {
        // holder is the (already created) activity_list_item (= ViewHolder-object)
        // - gets element from your dataset at this position
        // - replaces the contents of the view with that element
        final User user = users.get(position);

        holder.id.setText("" + user.getId());
        holder.first_name.setText(user.getFirstname());
        holder.last_name.setText(user.getLastname());
        holder.email.setText(user.getEmail());
        holder.place.setText(user.getPlace());


    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return users.size();

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // ViewHolder is the view of a activity_list_view
        // one drink_list_item contains 3 views
        // Provide a reference to each view in the activity_list_item

        private TextView id;
        private TextView first_name;
        private TextView last_name;
        private TextView email;
        private TextView place;

        private Button details;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.participant_id);
            first_name = (TextView) itemView.findViewById(R.id.participant_first_name);
            last_name = (TextView) itemView.findViewById(R.id.participant_last_name);
            email = (TextView) itemView.findViewById(R.id.participant_email);
            place = (TextView) itemView.findViewById(R.id.participant_place);

            details = (Button) itemView.findViewById(R.id.btn_readUser);
            details.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickHandler.onActivityClick(v.findViewById(R.id.btn_readUser), Integer.parseInt(id.getText().toString()));
        }
    }
}
