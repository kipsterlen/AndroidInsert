package com.example.lterer.androidinsertt;import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<StudentDetails> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<StudentDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        StudentDetails studentDetails = MainImageUploadInfoList.get(position);

        holder.homeTextView.setText(studentDetails.getHomeGame());

        holder.awayTextView.setText(studentDetails.getAwayGame());
        holder.pickTextView.setText(studentDetails.getPick());

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView homeTextView;
        public TextView awayTextView;
        public TextView pickTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            homeTextView = (TextView) itemView.findViewById(R.id.home);

            awayTextView = (TextView) itemView.findViewById(R.id.away);
            pickTextView = (TextView) itemView.findViewById(R.id.pick);
        }
    }
}

